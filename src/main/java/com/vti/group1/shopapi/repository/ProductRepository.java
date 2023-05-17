package com.vti.group1.shopapi.repository;

import com.vti.group1.shopapi.entity.Color;
import com.vti.group1.shopapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById(Long id);
    Optional<Product> findByColor(Long id);
}
