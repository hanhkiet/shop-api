package com.vti.group1.shopapi.repository;

import com.vti.group1.shopapi.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, String> {
    Optional<Order> findByUuid(String uuid);
}
