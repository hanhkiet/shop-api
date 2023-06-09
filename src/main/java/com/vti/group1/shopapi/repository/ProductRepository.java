package com.vti.group1.shopapi.repository;

import com.vti.group1.shopapi.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends PagingAndSortingRepository<Product, String> {

    Optional<Product> findByUuid(String uuid);

    @Query("SELECT p FROM Product p WHERE p.name LIKE %?1%")
    Page<Product> searchProducts(String query, PageRequest of);

    Product save(Product product);

    void delete(Product product);

    List<Product> findAll();
}
