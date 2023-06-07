package com.vti.group1.shopapi.controller;

import java.util.List;

import com.vti.group1.shopapi.entity.Color;
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
            @RequestParam(defaultValue = "UNDEFINED") CollectionType type,
            @RequestParam(defaultValue = "") String query,
            @RequestParam(defaultValue = "0") Long collectionId,
            @RequestParam(defaultValue = "UNDEFINED") Color color) {
        return ResponseEntity.ok(storageService.getAllProducts(type, query, collectionId, color));
    }

    @PostMapping("/products")
    public ResponseEntity<ProductDto> addProduct(
            @RequestBody ProductDto productDto) {
        return ResponseEntity.ok(storageService.addProduct(productDto));
    }

    @PutMapping("/products/{uuid}")
    public ResponseEntity<ProductDto> updateProduct(
            @PathVariable String uuid, @RequestBody ProductDto productDto) {
        return ResponseEntity.ok(storageService.updateProduct(uuid, productDto));
    }

    @DeleteMapping("/products/{uuid}")
    public ResponseEntity<String> deleteProduct(
            @PathVariable String uuid) {
        storageService.deleteProduct(uuid);
        return ResponseEntity.ok("Product deleted");
    }
}
