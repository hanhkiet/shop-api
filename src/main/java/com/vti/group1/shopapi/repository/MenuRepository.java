package com.vti.group1.shopapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.group1.shopapi.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
