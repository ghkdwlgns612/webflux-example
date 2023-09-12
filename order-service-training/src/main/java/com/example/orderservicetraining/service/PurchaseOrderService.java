package com.example.orderservicetraining.service;

import com.example.orderservicetraining.client.ProductClient;
import com.example.orderservicetraining.client.UserClient;
import com.example.orderservicetraining.dto.PurchaseOrderRequest;
import com.example.orderservicetraining.dto.PurchaseOrderResponse;
import com.example.orderservicetraining.dto.TransactionResponseDto;
import com.example.orderservicetraining.repository.PurchaseOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PurchaseOrderService {

    private final ProductClient productClient;
    private final UserClient userClient;
    private final PurchaseOrderRepository purchaseOrderRepository;

    public Mono<TransactionResponseDto> getAmountByUserId(Integer id) {
        return null;
    }

    public Mono<PurchaseOrderResponse> orderProduct(PurchaseOrderRequest request) {
        return null;
    }
}
