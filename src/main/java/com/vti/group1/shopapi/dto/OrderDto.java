package com.vti.group1.shopapi.dto;

import com.vti.group1.shopapi.entity.OrderAddress;
import com.vti.group1.shopapi.entity.OrderDetail;
import com.vti.group1.shopapi.entity.OrderPaymentMethod;
import com.vti.group1.shopapi.entity.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private String uuid;
    private OrderAddress address;
    private List<OrderDetail> details;
    private OrderStatus status;
    private OrderPaymentMethod paymentMethod;
    private Date createdAt;
    private Double totalPrice;
}
