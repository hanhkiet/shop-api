package com.vti.group1.shopapi.controller;

import com.vti.group1.shopapi.dto.OrderDto;
import com.vti.group1.shopapi.dto.ProductDto;
import com.vti.group1.shopapi.entity.*;
import com.vti.group1.shopapi.service.StorageService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/catalogs/{uuid}")
    public ResponseEntity<ProductDto> addCatalog(
            @PathVariable String uuid, @RequestBody List<Catalog> catalogs) {
        return ResponseEntity.ok(storageService.addCatalog(uuid, catalogs));
    }

    @GetMapping("/catalogs/{uuid}")
    public ResponseEntity<List<Catalog>> getCatalogs(
            @PathVariable String uuid) {
        return ResponseEntity.ok(storageService.getCatalogs(uuid));
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        return ResponseEntity.ok(storageService.getAllOrders());
    }

    @PutMapping("/orders/{uuid}")
    public ResponseEntity<OrderDto> updateStatus(
            @PathVariable String uuid, @RequestBody OrderStatus status) {
        return ResponseEntity.ok(storageService.updateStatus(uuid, status));
    }
}
