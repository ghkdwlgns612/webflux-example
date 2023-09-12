package com.example.orderservicetraining.entity;

import com.example.orderservicetraining.dto.OrderStatus;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Data
@ToString
@NoArgsConstructor
public class PurchaseOrder {

    @Id
    private Integer id;
    private String productId;
    private Integer userId;
    private Integer amount;
    private OrderStatus status;
}
