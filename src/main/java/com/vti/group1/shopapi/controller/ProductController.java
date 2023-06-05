package com.vti.group1.shopapi.controller;

import com.vti.group1.shopapi.entity.Product;
import com.vti.group1.shopapi.repository.ProductRepository;
import com.vti.group1.shopapi.service.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@Transactional
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(
            @RequestParam(defaultValue = "0") Integer page) {
        return ResponseEntity.ok().body(productService.getAllProducts(page));
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Product> getProductByUuid(
           @PathVariable String uuid) {
        return ResponseEntity.ok().body(productService.findByUuid(uuid));
    }
}
