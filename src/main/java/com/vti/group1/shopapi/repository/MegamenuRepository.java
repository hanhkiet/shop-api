package com.vti.group1.shopapi.repository;

import com.vti.group1.shopapi.entity.Megamenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
public interface MegamenuRepository extends JpaRepository<Megamenu, Long> {
    Optional<Megamenu> findById(Long id);
    List<Megamenu> findByMenuId(Long menuId);
}
