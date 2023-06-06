package com.vti.group1.shopapi.repository;

import com.vti.group1.shopapi.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}
