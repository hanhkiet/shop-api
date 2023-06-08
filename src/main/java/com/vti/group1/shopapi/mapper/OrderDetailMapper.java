package com.vti.group1.shopapi.mapper;

import com.vti.group1.shopapi.dto.OrderDetailDto;
import com.vti.group1.shopapi.entity.OrderDetail;

public interface OrderDetailMapper {
    OrderDetailDto toDto(OrderDetail orderDetail);
}
