package com.vti.group1.shopapi.service;

import com.vti.group1.shopapi.dto.CheckoutDto;
import com.vti.group1.shopapi.dto.CheckoutItemDto;
import com.vti.group1.shopapi.dto.OrderDto;
import com.vti.group1.shopapi.entity.*;
import com.vti.group1.shopapi.exception.RestException;
import com.vti.group1.shopapi.mapper.OrderMapper;
import com.vti.group1.shopapi.repository.OrderAddressRepository;
import com.vti.group1.shopapi.repository.OrderDetailRepository;
import com.vti.group1.shopapi.repository.OrderRepository;
import com.vti.group1.shopapi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final CustomerAccountService customerAccountService;
    private final OrderAddressRepository orderAddressRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final OrderMapper orderMapper;

    public List<OrderDto> getAllOrders(String name) {
        var customer = customerAccountService.findCustomerByUsername(name);

        return customer.getOrders().stream().map(orderMapper::toDto).toList();
    }

    public void checkout(String name, CheckoutDto checkoutDto) {
        var customer = customerAccountService.findCustomerByUsername(name);

        OrderAddress address = checkoutDto.getAddress();
        if (address.getUuid() != null)
            address = orderAddressRepository.findByUuid(address.getUuid())
                    .orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND,
                                                         "Address not " + "found"));
        else {
            address.setCustomer(customer);
            address = orderAddressRepository.saveAndFlush(address);
        }

        List<CheckoutItemDto> items = checkoutDto.getItems();

        List<OrderDetail> details = items.stream().map(item -> {
            var product = productRepository.findByUuid(item.getProductUuid())
                    .orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND,
                                                         "Product not " + "found"));
            if (!isCatalogAvailable(product, item)) throw new RestException(HttpStatus.BAD_REQUEST,
                                                                            "Product " +
                                                                                    product.getName() +
                                                                                    " is not " +
                                                                                    "available");
            subtractCatalogQuantity(product, item);

            var detail = OrderDetail.builder().product(product).size(item.getSize())
                    .quantity(item.getQuantity()).build();
            return orderDetailRepository.saveAndFlush(detail);
        }).collect(Collectors.toList());

        var order = Order.builder().customer(customer).address(address).details(details)
                .paymentMethod(OrderPaymentMethod.COD).status(OrderStatus.PENDING)
                .createdAt(new Date()).build();

        orderRepository.saveAndFlush(order);
    }

    private boolean isCatalogAvailable(Product product, CheckoutItemDto item) {
        return product.getCatalogs().stream().anyMatch(catalog -> catalog.getSize()
                .equals(item.getSize()) && catalog.getQuantity() >= item.getQuantity());
    }

    private void subtractCatalogQuantity(Product product, CheckoutItemDto item) {
        product.getCatalogs().stream().filter(catalog -> catalog.getSize().equals(item.getSize()))
                .findFirst().ifPresent(catalog -> {
                    catalog.setQuantity(catalog.getQuantity() - item.getQuantity());
                });
    }

    public OrderDto getOrder(String uuid) {
        var order = orderRepository.findByUuid(uuid)
                .orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND, "Order not found"));

        return orderMapper.toDto(order);
    }
}
