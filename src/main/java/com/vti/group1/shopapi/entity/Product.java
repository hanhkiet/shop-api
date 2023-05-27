package com.vti.group1.shopapi.entity;

import com.vti.group1.shopapi.utils.StringListConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;
    private String name;
    private Double price;
    @Enumerated(EnumType.STRING)
    private Color color;
    @Convert(converter = StringListConverter.class)
    @Column(length=1000)
    private List<String> images;
}