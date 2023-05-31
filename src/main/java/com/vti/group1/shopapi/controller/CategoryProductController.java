package com.vti.group1.shopapi.controller;

import com.vti.group1.shopapi.entity.CategoryProduct;
import com.vti.group1.shopapi.repository.CategoryProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/category-products")
@RequiredArgsConstructor
public class CategoryProductController {
    private final CategoryProductRepository categoryProductRepository;
    @GetMapping()
    public ResponseEntity<List<CategoryProduct>> getAllItems() {
        List<CategoryProduct> categoryProducts = categoryProductRepository.findAll();
        return ResponseEntity.ok(categoryProducts.isEmpty() ? Collections.emptyList() : categoryProducts);
    }
}
