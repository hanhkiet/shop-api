package com.vti.group1.shopapi.repository;

import com.vti.group1.shopapi.entity.MegaMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
public interface MegaMenuRepository extends JpaRepository<MegaMenu, Long> {
}