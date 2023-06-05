package com.vti.group1.shopapi.service;

import com.vti.group1.shopapi.entity.Collection;
import com.vti.group1.shopapi.entity.Product;
import com.vti.group1.shopapi.exception.RestException;
import com.vti.group1.shopapi.repository.CollectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CollectionService {
    private final CollectionRepository collectionRepository;

    public List<Collection> getAllCollections() {
        return collectionRepository.findAll();
    }

    public List<Product> getProductsByCollectionId(Long id) {
        Collection collection = collectionRepository.findById(id)
                .orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND, "Collection not found"));

        return collection.getProducts();
    }
}
