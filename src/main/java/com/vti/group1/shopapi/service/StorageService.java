package com.vti.group1.shopapi.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.vti.group1.shopapi.dto.ProductDto;
import com.vti.group1.shopapi.entity.Collection;
import com.vti.group1.shopapi.entity.CollectionType;
import com.vti.group1.shopapi.entity.Product;
import com.vti.group1.shopapi.exception.RestException;
import com.vti.group1.shopapi.mapper.ProductMapper;
import com.vti.group1.shopapi.repository.CollectionRepository;
import com.vti.group1.shopapi.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StorageService {
    private final CollectionRepository collectionRepository;
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public List<Collection> getAllCollections() {
        return collectionRepository.findAll();
    }

    public Collection updateCollectionData(Long id, Collection c) {
        Collection collection = collectionRepository.findById(id)
                .orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND, "Collection not found"));

        collection.setName(c.getName());
        collection.setType(c.getType());

        return collectionRepository.save(collection);
    }

    public Collection addCollection(Collection c) {
        Collection collection = Collection.builder().name(c.getName()).type(c.getType()).build();

        return collectionRepository.save(collection);
    }

    public void deleteCollection(Long id) {
        Collection collection = collectionRepository.findById(id)
                .orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND, "Catalog not found"));

        collectionRepository.delete(collection);
    }

    public List<CollectionType> getAllCollectionTypes() {
        return List.of(CollectionType.values());
    }

    public List<ProductDto> getAllProducts(CollectionType collectionType, int collectionId) {
        List<Product> products = productRepository.findAll();
        var resultStream = products.stream()
                .filter(p -> p.getCollections().stream().anyMatch(c -> c.getType() == collectionType));

        if (collectionId != 0) {
            resultStream = resultStream
                    .filter(p -> p.getCollections().stream().anyMatch(c -> c.getId() == collectionId));
        }

        return resultStream.map(productMapper::toDto).toList();
    }
}
