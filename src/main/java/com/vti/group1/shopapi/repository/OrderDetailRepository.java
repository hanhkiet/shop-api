package com.vti.group1.shopapi.repository;

import com.vti.group1.shopapi.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}
