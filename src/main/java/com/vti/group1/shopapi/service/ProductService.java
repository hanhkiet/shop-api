package com.vti.group1.shopapi.service;

import com.vti.group1.shopapi.entity.Product;
import com.vti.group1.shopapi.exception.RestException;
import com.vti.group1.shopapi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private static final Integer PAGE_SIZE = 5;
    private final ProductRepository productRepository;

    public Product findByUuid(String uuid) {
        Product product = productRepository.findByUuid(uuid)
                .orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND, "Product not found"));

        return product;
    }

    public List<Product> getAllProducts(Integer page) {
        return productRepository.findAll(PageRequest.of(page, PAGE_SIZE)).toList();
    }
}
