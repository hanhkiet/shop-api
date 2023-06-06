package com.vti.group1.shopapi.entity;

import com.vti.group1.shopapi.util.StringListConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    private String name;
    private double price;

    @Enumerated(EnumType.STRING)
    private Color color;

    @Convert(converter = StringListConverter.class)
    @Column(length = 1000)
    private List<String> images;

    @ManyToMany
    @JoinTable(name = "product_collection", joinColumns = @JoinColumn(name = "product_uuid"),
            inverseJoinColumns = @JoinColumn(name = "collection_id"))
    private List<Collection> collections;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Catalog> catalogs;
}
