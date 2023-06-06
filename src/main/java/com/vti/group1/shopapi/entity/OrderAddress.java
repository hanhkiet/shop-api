package com.vti.group1.shopapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_addresses")
public class OrderAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    private String recipientName;

    private String recipientPhone;

    private String street;

    private String district;

    private String city;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;
}
