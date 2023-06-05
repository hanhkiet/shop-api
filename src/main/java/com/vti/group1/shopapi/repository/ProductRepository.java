package com.vti.group1.shopapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.group1.shopapi.entity.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface ProductRepository extends PagingAndSortingRepository<Product, String> {

    Optional<Product> findByUuid(String uuid);
}
