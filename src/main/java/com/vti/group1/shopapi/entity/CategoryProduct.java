package com.vti.group1.shopapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "category_products")
public class CategoryProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(referencedColumnName = "uuid")
    @JsonIgnore
    private Product product;
    @Column(name = "product_uuid", insertable = false, updatable = false)
    private String productUuid;
    public String getProductUuid() {
        return product.getUuid();
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    @JsonIgnore
    private ProductCollection productCollection;
    @Column(name = "product_collection_id", insertable = false, updatable = false)
    private Long productCollectionId;
    public Long getProductCollectionId() {
        return productCollection.getId();
    }
}
