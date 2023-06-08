package com.vti.group1.shopapi.repository;

import com.vti.group1.shopapi.entity.OrderAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderAddressRepository extends JpaRepository<OrderAddress, String> {
    List<OrderAddress> findByCustomerUuid(String uuid);

    Optional<OrderAddress> findByUuid(String uuid);
}
