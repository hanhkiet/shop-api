package com.vti.group1.shopapi.repository;

import com.vti.group1.shopapi.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, String> {
}
