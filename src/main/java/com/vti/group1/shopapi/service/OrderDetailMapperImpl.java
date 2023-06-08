package com.vti.group1.shopapi.service;

import com.vti.group1.shopapi.dto.OrderDetailDto;
import com.vti.group1.shopapi.entity.OrderDetail;
import com.vti.group1.shopapi.mapper.OrderDetailMapper;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailMapperImpl implements OrderDetailMapper {

    @Override
    public OrderDetailDto toDto(OrderDetail orderDetail) {
        return OrderDetailDto.builder()
                .uuid(orderDetail.getProduct().getUuid())
                .name(orderDetail.getProduct().getName())
                .price(orderDetail.getProduct().getPrice())
                .color(orderDetail.getProduct().getColor())
                .size(orderDetail.getSize())
                .quantity(orderDetail.getQuantity())
                .build();
    }
}
