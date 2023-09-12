package com.example.orderservicetraining.dto;


import lombok.ToString;

@ToString
public record PurchaseOrderRequest(String productId, Integer userId) {
}
