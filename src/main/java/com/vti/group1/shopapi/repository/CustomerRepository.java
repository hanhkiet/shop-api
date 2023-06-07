package com.vti.group1.shopapi.repository;

import java.util.Optional;

import com.vti.group1.shopapi.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.group1.shopapi.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    Optional<Customer> findByUserId(Long id);

    Order findOrderByUuid(String uuid);
}
