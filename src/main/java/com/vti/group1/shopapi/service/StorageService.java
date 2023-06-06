package com.vti.group1.shopapi.service;

import java.util.List;
import java.util.Objects;

import com.vti.group1.shopapi.entity.Color;
import com.vti.group1.shopapi.repository.CatalogRepository;
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
    private final CatalogRepository catalogRepository;
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

    public List<ProductDto> getAllProducts(
            CollectionType collectionType, String query, Long collectionId, Color color) {
        List<Product> products = productRepository.findAll();
        var resultStream = products.stream();

        if (collectionType != CollectionType.UNDEFINED) {
            resultStream = resultStream.filter(p -> p.getCollections().stream()
                    .anyMatch(c -> c.getType() == collectionType));
        }

        if (!query.isBlank()) {
            resultStream = resultStream.filter(p -> p.getName().toLowerCase()
                    .contains(query.toLowerCase()));
        }

        if (collectionId != 0) {
            resultStream = resultStream.filter(p -> p.getCollections().stream()
                    .anyMatch(c -> Objects.equals(c.getId(), collectionId)));
        }

        if (color != Color.UNDEFINED) {
            resultStream = resultStream.filter(p -> p.getColor() == color);
        }

        return resultStream.map(productMapper::toDto).toList();
    }

    public ProductDto addProduct(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);

        return productMapper.toDto(productRepository.save(product));
    }

    public void deleteProduct(String uuid) {
        Product product = productRepository.findByUuid(uuid)
                .orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND, "Product not found"));

        productRepository.delete(product);
    }

    public ProductDto updateProduct(String uuid, ProductDto productDto) {
        Product product = productRepository.findByUuid(uuid)
                .orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND, "Product not found"));

        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setColor(productDto.getColor());
        product.setImages(productDto.getImages());
        product.setCollections(productDto.getCollections());

        return productMapper.toDto(productRepository.save(product));
    }
}
