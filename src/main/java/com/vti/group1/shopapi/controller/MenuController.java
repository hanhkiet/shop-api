package com.vti.group1.shopapi.controller;

import com.vti.group1.shopapi.entity.Menu;
import com.vti.group1.shopapi.entity.Product;
import com.vti.group1.shopapi.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/menus")
@RequiredArgsConstructor
public class MenuController {
    private final MenuRepository menuRepository;

    @GetMapping()
    public ResponseEntity<List<Menu>> getAllProducts() {
        List<Menu> menus = menuRepository.findAll();
        return ResponseEntity.ok(menus.isEmpty() ? Collections.emptyList() : menus);
    }
}