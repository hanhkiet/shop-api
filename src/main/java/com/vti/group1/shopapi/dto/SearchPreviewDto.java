package com.vti.group1.shopapi.dto;

import com.vti.group1.shopapi.entity.Product;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SearchPreviewDto {
    List<Product> products;
    Integer total;
}
