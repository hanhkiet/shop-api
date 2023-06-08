package com.vti.group1.shopapi.service;

import com.vti.group1.shopapi.dto.OrderDetailDto;
import com.vti.group1.shopapi.dto.OrderDto;
import com.vti.group1.shopapi.dto.ProductDto;
import com.vti.group1.shopapi.entity.*;
import com.vti.group1.shopapi.exception.RestException;
import com.vti.group1.shopapi.mapper.OrderDetailMapper;
import com.vti.group1.shopapi.mapper.OrderMapper;
import com.vti.group1.shopapi.mapper.ProductMapper;
import com.vti.group1.shopapi.repository.CollectionRepository;
import com.vti.group1.shopapi.repository.OrderRepository;
import com.vti.group1.shopapi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class StorageService {
    private final CollectionRepository collectionRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final ProductMapper productMapper;
    private final OrderMapper orderMapper;
    private final OrderDetailMapper orderDetailMapper;

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

    public ProductDto addCatalog(String uuid, List<Catalog> catalogs) {
        Product product = productRepository.findByUuid(uuid)
                .orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND, "Product not found"));

        List<Catalog> productCatalogs = product.getCatalogs();
        List<Catalog> newCatalogs = new LinkedList<>();

        for (Catalog catalog : catalogs) {
            Catalog productCatalog = productCatalogs.stream().filter(c -> c.getSize() ==
                    catalog.getSize()).findFirst().orElse(null);

            if (productCatalog != null) {
                productCatalog.setQuantity(productCatalog.getQuantity() + catalog.getQuantity());
            } else {
                catalog.setProduct(product);
                newCatalogs.add(catalog);
            }
        }

        productCatalogs.addAll(newCatalogs);

        return productMapper.toDto(productRepository.save(product));
    }

    public List<Catalog> getCatalogs(String uuid) {
        Product product = productRepository.findByUuid(uuid)
                .orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND, "Product not found"));

        return product.getCatalogs();
    }

    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll().stream().map(orderMapper::toDto).toList();
    }

    public OrderDto updateStatus(String uuid, OrderStatus status) {
        Order order = orderRepository.findByUuid(uuid)
                .orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND, "Order not found"));

        order.setStatus(status);
        return orderMapper.toDto(orderRepository.save(order));
    }

    public List<OrderDetailDto> getOrderDetails(String uuid) {
        Order order = orderRepository.findByUuid(uuid)
                .orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND, "Order not found"));

        return order.getDetails().stream().map(orderDetailMapper::toDto).toList();
    }
}
