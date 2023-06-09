package com.vti.group1.shopapi.service;

import com.vti.group1.shopapi.dto.OrderDto;
import com.vti.group1.shopapi.entity.Order;
import com.vti.group1.shopapi.mapper.OrderMapper;
import org.springframework.stereotype.Service;

@Service
public class OrderMapperImpl implements OrderMapper {
    @Override
    public OrderDto toDto(Order order) {
        var details = order.getDetails();
        Double totalPrice = details.stream().mapToDouble(detail -> detail.getProduct().getPrice() *
                detail.getQuantity()).sum();

        return OrderDto.builder().uuid(order.getUuid()).address(order.getAddress())
                .status(order.getStatus()).totalPrice(totalPrice)
                .paymentMethod(order.getPaymentMethod()).createdAt(order.getCreatedAt()).build();
    }
}
