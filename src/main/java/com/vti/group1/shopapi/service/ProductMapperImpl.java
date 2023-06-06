package com.vti.group1.shopapi.service;

import org.springframework.stereotype.Service;

import com.vti.group1.shopapi.dto.ProductDto;
import com.vti.group1.shopapi.entity.Product;
import com.vti.group1.shopapi.mapper.ProductMapper;

@Service
public class ProductMapperImpl implements ProductMapper {

  @Override
  public ProductDto toDto(Product product) {
    return ProductDto.builder()
        .uuid(product.getUuid())
        .name(product.getName())
        .price(product.getPrice())
        .color(product.getColor())
        .collections(product.getCollections())
        .images(product.getImages())
        .build();
  }

  @Override
  public Product toEntity(ProductDto productDto) {
    return Product.builder()
        .name(productDto.getName())
        .price(productDto.getPrice())
        .color(productDto.getColor())
        .collections(productDto.getCollections())
        .images(productDto.getImages())
        .build();
  }

}
