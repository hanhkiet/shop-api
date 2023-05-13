package com.vti.group1.shopapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.group1.shopapi.entity.OrderAddress;

public interface OrderAddressRepository extends JpaRepository<OrderAddress, String> {

}
