package com.vti.group1.shopapi.dto;

import com.vti.group1.shopapi.entity.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CheckoutItemDto {
    private String productUuid;
    private Size size;
    private Integer quantity;
}
