package com.vti.group1.shopapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.group1.shopapi.dto.ProductDto;
import com.vti.group1.shopapi.entity.Collection;
import com.vti.group1.shopapi.entity.CollectionType;
import com.vti.group1.shopapi.service.StorageService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/manager/storage")
@Transactional
@RequiredArgsConstructor
public class StorageController {
    private final StorageService storageService;

    @GetMapping("/collections")
    public ResponseEntity<List<Collection>> getAllCollections() {
        return ResponseEntity.ok(storageService.getAllCollections());
    }

    @PostMapping("/collections")
    public ResponseEntity<Collection> addCollection(
            @RequestBody Collection collection) {
        return ResponseEntity.ok(storageService.addCollection(collection));
    }

    @PutMapping("/collections/{id}")
    public ResponseEntity<Collection> updateCollectionName(
            @PathVariable Long id, @RequestBody Collection collection) {
        return ResponseEntity.ok(storageService.updateCollectionData(id, collection));
    }

    @DeleteMapping("/collections/{id}")
    public ResponseEntity<String> deleteCollection(
            @PathVariable Long id) {
        storageService.deleteCollection(id);
        return ResponseEntity.ok("Collection deleted");
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getAllProducts(
            @RequestParam CollectionType type, @RequestParam int collectionId) {
        return ResponseEntity.ok(storageService.getAllProducts(type, collectionId));
    }
}
