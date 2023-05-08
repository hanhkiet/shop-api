package com.vti.group1.shopapi.controller;

import com.vti.group1.shopapi.entity.Color;
import com.vti.group1.shopapi.entity.Product;
import com.vti.group1.shopapi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;
    @GetMapping({"", "/"})
    public ResponseEntity<List<Product>> getAllProducts() {
        var products = productRepository.findAll();
        if(products.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(products);
    }
    @GetMapping("/:id")
    public ResponseEntity<Product> getProductById(
            @PathVariable Long id
    ) {
        var product = productRepository.findById(id);
        if(product.isPresent()) {
            return ResponseEntity.ok(product.get());
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/vv")
    public String hello() {
        return "VTI Shop API";
    }

}
