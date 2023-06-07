package com.vti.group1.shopapi.dto;

import java.util.List;

import com.vti.group1.shopapi.entity.Collection;
import com.vti.group1.shopapi.entity.Color;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {
    private String uuid;
    private String name;
    private Double price;
    private Color color;
    private List<String> images;
    private List<Collection> collections;
}
