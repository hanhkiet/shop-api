package com.vti.group1.shopapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.vti.group1.shopapi.entity.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, String> {

    Optional<Product> findByUuid(String uuid);

    List<Product> findAll();
}
