package com.vti.group1.shopapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.vti.group1.shopapi.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.vti.group1.shopapi.entity.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, String> {

    Optional<Product> findByUuid(String uuid);

    @Query("SELECT p FROM Product p WHERE p.name LIKE %?1%")
    Page<Product> searchProducts(String query, PageRequest of);
}
