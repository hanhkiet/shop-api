package com.vti.group1.shopapi.controller;

import java.util.List;

import com.vti.group1.shopapi.dto.SearchPreviewDto;
import com.vti.group1.shopapi.dto.SearchResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.group1.shopapi.entity.Product;
import com.vti.group1.shopapi.service.ProductService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

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

    @GetMapping("/search/preview")
    public ResponseEntity<SearchPreviewDto> searchPreviewProducts(
            @RequestParam String query) {
        return ResponseEntity.ok().body(productService.searchPreviewProducts(query));
    }

    @GetMapping("/search")
    public ResponseEntity<SearchResult> searchProducts(
            @RequestParam String query,
            @RequestParam(defaultValue = "0") Integer page) {
        return ResponseEntity.ok().body(productService.searchAllProducts(query, page));
    }
}
