package com.vti.group1.shopapi.service;

import com.vti.group1.shopapi.dto.AddressDto;
import com.vti.group1.shopapi.entity.OrderAddress;
import com.vti.group1.shopapi.mapper.AddressMapper;
import org.springframework.stereotype.Service;

@Service
public class AddressMapperImpl implements AddressMapper {
    @Override
    public OrderAddress toEntity(AddressDto addressDto) {
        return OrderAddress.builder()
                .recipientName(addressDto.getRecipientName())
                .recipientPhone(addressDto.getRecipientPhone())
                .street(addressDto.getStreet())
                .district(addressDto.getDistrict())
                .city(addressDto.getCity())
                .build();
    }

    @Override
    public AddressDto toDto(OrderAddress orderAddress) {
        return AddressDto.builder()
                .uuid(orderAddress.getUuid())
                .recipientName(orderAddress.getRecipientName())
                .recipientPhone(orderAddress.getRecipientPhone())
                .street(orderAddress.getStreet())
                .district(orderAddress.getDistrict())
                .city(orderAddress.getCity())
                .build();
    }
}
