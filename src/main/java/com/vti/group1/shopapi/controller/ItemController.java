package com.vti.group1.shopapi.controller;

import com.vti.group1.shopapi.entity.Item;
import com.vti.group1.shopapi.repository.ItemRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/items")
@RequiredArgsConstructor
@Transactional
public class ItemController {
    private final ItemRepository itemRepository;
    @GetMapping()
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = itemRepository.findAll();
        return ResponseEntity.ok(items.isEmpty() ? Collections.emptyList() : items);
    }
}
