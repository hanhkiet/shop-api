package com.vti.group1.shopapi.mapper;

import com.vti.group1.shopapi.dto.AddressDto;
import com.vti.group1.shopapi.entity.OrderAddress;

public interface AddressMapper {
    OrderAddress toEntity(AddressDto addressDto);

    AddressDto toDto(OrderAddress orderAddress);
}
