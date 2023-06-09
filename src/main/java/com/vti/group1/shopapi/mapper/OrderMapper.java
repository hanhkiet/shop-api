package com.vti.group1.shopapi.mapper;

import com.vti.group1.shopapi.dto.OrderDto;
import com.vti.group1.shopapi.entity.Order;

public interface OrderMapper {
    OrderDto toDto(Order order);
}
