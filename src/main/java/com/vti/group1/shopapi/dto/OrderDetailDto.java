package com.vti.group1.shopapi.dto;

import com.vti.group1.shopapi.entity.Color;
import com.vti.group1.shopapi.entity.Product;
import com.vti.group1.shopapi.entity.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailDto {
    private String uuid;
    private String name;
    private Double price;
    private Color color;
    private Size size;
    private Integer quantity;
}
