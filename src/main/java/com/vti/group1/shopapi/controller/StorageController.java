package com.vti.group1.shopapi.controller;

import com.vti.group1.shopapi.entity.Collection;
import com.vti.group1.shopapi.entity.CollectionType;
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
}
