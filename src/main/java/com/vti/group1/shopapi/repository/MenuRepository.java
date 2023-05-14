package com.vti.group1.shopapi.repository;

import com.vti.group1.shopapi.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface MenuRepository extends JpaRepository<Menu, Long> {
    Optional<Menu> findById(Long id);
}
