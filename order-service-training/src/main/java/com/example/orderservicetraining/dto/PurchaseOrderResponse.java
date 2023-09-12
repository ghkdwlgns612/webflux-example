package com.example.orderservicetraining.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PurchaseOrderResponse {

    private Integer orderId;
    private Integer userId;
    private String productId;
    private Integer amount;
    private OrderStatus status;
}
