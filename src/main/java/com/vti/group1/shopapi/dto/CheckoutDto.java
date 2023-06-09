package com.vti.group1.shopapi.dto;

import com.vti.group1.shopapi.entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CheckoutDto {
    private OrderAddress address;
    private List<CheckoutItemDto> items;
}
