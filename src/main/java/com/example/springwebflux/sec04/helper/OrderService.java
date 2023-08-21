package com.example.springwebflux.sec04.helper;

import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderService {

    private static Map<Integer, List<PurchaseOrder>> db = new HashMap<>();

    static {
        List<PurchaseOrder> list1 = List.of(new PurchaseOrder(1), new PurchaseOrder(1), new PurchaseOrder(1));
        List<PurchaseOrder> list2 = List.of(new PurchaseOrder(2), new PurchaseOrder(2));
        List<PurchaseOrder> list3 = List.of(new PurchaseOrder(3), new PurchaseOrder(3), new PurchaseOrder(3), new PurchaseOrder(3));
        List<PurchaseOrder> list4 = List.of(new PurchaseOrder(4), new PurchaseOrder(4), new PurchaseOrder(4));
        List<PurchaseOrder> list5 = List.of(new PurchaseOrder(5), new PurchaseOrder(5), new PurchaseOrder(5), new PurchaseOrder(5), new PurchaseOrder(5));

        db.put(1, list1);
        db.put(2, list2);
        db.put(3, list3);
        db.put(4, list4);
        db.put(5, list5);
    }

    public static Flux<PurchaseOrder> getOrders(int userId) {
        return Flux.create((FluxSink<PurchaseOrder> purchaseOrderFluxSink) -> {
                    db.get(userId)
                            .forEach(purchaseOrderFluxSink::next);
                    purchaseOrderFluxSink.complete();
                })
                .delayElements(Duration.ofSeconds(1));
    }
}
