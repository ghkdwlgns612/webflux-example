package com.example.orderservicetraining.controller;

import com.example.orderservicetraining.dto.PurchaseOrderRequest;
import com.example.orderservicetraining.dto.PurchaseOrderResponse;
import com.example.orderservicetraining.dto.TransactionResponseDto;
import com.example.orderservicetraining.service.PurchaseOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("order")
@RequiredArgsConstructor
public class PurchaseOrderController {

    private final PurchaseOrderService purchaseOrderService;

    @GetMapping("user/{id}")
    public Mono<TransactionResponseDto> getPurchaseOrder(@PathVariable Integer id) {
        return purchaseOrderService.getAmountByUserId(id);
    }

    @PostMapping
    public Mono<PurchaseOrderResponse> orderProduct(@RequestBody PurchaseOrderRequest request) {
        return purchaseOrderService.orderProduct(request);
    }

}
