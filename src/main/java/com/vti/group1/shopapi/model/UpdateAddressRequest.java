package com.vti.group1.shopapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAddressRequest {

    private String addressId;
    private String recipientName;
    private String recipientPhone;
    private String street;
    private String district;
    private String city;
}
