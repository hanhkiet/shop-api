package com.vti.group1.shopapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.group1.shopapi.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

    Customer findByEmail(String email);

    boolean existsByEmail(String email);
}
