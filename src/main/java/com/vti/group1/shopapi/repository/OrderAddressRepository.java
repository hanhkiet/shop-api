package com.vti.group1.shopapi.repository;

import com.vti.group1.shopapi.entity.OrderAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderAddressRepository extends JpaRepository<OrderAddress, String> {
    List<OrderAddress> findByCustomerUuid(String uuid);
}
