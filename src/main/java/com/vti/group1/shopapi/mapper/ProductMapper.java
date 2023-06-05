package com.vti.group1.shopapi.mapper;

import com.vti.group1.shopapi.dto.ProductDto;
import com.vti.group1.shopapi.entity.Product;

public interface ProductMapper {
  ProductDto toDto(Product product);
}
