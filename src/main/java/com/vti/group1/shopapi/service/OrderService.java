package com.vti.group1.shopapi.service;

import com.vti.group1.shopapi.dto.OrderDto;
import com.vti.group1.shopapi.dto.ProductDto;
import com.vti.group1.shopapi.entity.Order;
import com.vti.group1.shopapi.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final CustomerAccountService customerAccountService;
    private final CustomerRepository customerRepository;

    public List<Order> getAllOrders(String name) {
        var customer = customerAccountService.findCustomerByUsername(name);
        return customer.getOrders();
    }

    public void checkout(String name, OrderDto orderDto) {
        var customer = customerAccountService.findCustomerByUsername(name);
        var order = Order.builder().customer(customer).address(orderDto.getOrderAddress())
                .paymentMethod(orderDto.getPaymentMethod()).build();

        order.setCatalogs(orderDto.getCatalogs());
        customer.getOrders().add(order);
        customerRepository.save(customer);
    }

    public Order getOrder(String uuid) {
        return customerRepository.findOrderByUuid(uuid);
    }
}
