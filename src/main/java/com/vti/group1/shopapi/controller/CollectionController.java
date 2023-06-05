package com.vti.group1.shopapi.controller;

import com.vti.group1.shopapi.entity.Collection;
import com.vti.group1.shopapi.entity.Product;
import com.vti.group1.shopapi.service.CollectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/collections")
@RequiredArgsConstructor
@Transactional
public class CollectionController {
    private final CollectionService collectionService;

    @GetMapping
    public ResponseEntity<List<Collection>> getAllCollections() {
        return ResponseEntity.ok().body(collectionService.getAllCollections());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Product>> getProductsByCollectionId(
            @PathVariable Long id) {
        return ResponseEntity.ok().body(collectionService.getProductsByCollectionId(id));
    }
}
