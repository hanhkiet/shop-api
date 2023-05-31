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
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(referencedColumnName = "uuid")
    @JsonIgnore
    private Product product;
    @Column(name = "product_uuid", insertable = false, updatable = false)
    private String productUuid;
    @Enumerated(EnumType.STRING)
    private Size size;
    private Integer quantity;
    public String getProductUuid() {
        return product.getUuid();
    }
}
