package com.vti.group1.shopapi.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vti.group1.shopapi.entity.Collection;
import com.vti.group1.shopapi.entity.Color;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private String uuid;
    private String name;
    private Double price;
    private Color color;
    private List<String> images;
    private List<Collection> collections;
}
