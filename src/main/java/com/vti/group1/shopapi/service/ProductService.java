package com.vti.group1.shopapi.service;

import com.vti.group1.shopapi.dto.SearchPreviewDto;
import com.vti.group1.shopapi.dto.SearchResult;
import com.vti.group1.shopapi.entity.Product;
import com.vti.group1.shopapi.exception.RestException;
import com.vti.group1.shopapi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private static final Integer PAGE_SIZE = 40;
    private final ProductRepository productRepository;

    public Product findByUuid(String uuid) {
        return productRepository.findByUuid(uuid)
                .orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND, "Product not found"));
    }

    public List<Product> getAllProducts(Integer page) {
        return productRepository.findAll(PageRequest.of(page, PAGE_SIZE)).toList();
    }

    public SearchPreviewDto searchPreviewProducts(String query) {
        Page<Product> products = productRepository.searchProducts(query, PageRequest.of(0, 4));

        return SearchPreviewDto.builder().products(products.toList())
                .totalElements(products.getTotalElements()).build();
    }

    public SearchResult searchAllProducts(String query, Integer page) {
        Page<Product> products = productRepository.searchProducts(query, PageRequest.of(page,
                                                                                        PAGE_SIZE));

        return SearchResult.builder().products(products.toList())
                .totalPages(products.getTotalPages()).totalElements(products.getTotalElements())
                .build();
    }
}
