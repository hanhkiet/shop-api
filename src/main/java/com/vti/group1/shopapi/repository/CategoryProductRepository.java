package com.vti.group1.shopapi.repository;

import com.vti.group1.shopapi.entity.CategoryProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryProductRepository extends JpaRepository<CategoryProduct, String> {
}
