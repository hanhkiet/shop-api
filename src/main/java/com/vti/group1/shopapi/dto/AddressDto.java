package com.vti.group1.shopapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private String uuid;
    private String recipientName;
    private String recipientPhone;
    private String street;
    private String district;
    private String city;
}
