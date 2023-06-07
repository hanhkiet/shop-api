package com.vti.group1.shopapi.dto;

import com.vti.group1.shopapi.entity.Catalog;
import com.vti.group1.shopapi.entity.OrderAddress;
import com.vti.group1.shopapi.entity.OrderPaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private OrderAddress orderAddress;
    private List<Catalog> catalogs;
    private OrderPaymentMethod paymentMethod;
}
