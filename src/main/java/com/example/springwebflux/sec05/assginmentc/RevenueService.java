package com.example.springwebflux.sec05.assginmentc;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class RevenueService {

    private Map<String, Double> db = new HashMap<>();

    public RevenueService() {
        db.put("Kids", 0.0);
        db.put("Automotive", 0.0);
    }

    public Consumer<PurchaseOrder> subscribeOrderStream() {
        return po -> db.put(po.getCategory(), db.getOrDefault(po.getCategory(), 0.0) + po.getPrice());
    }

    public Flux<String> revenueStream() {
        return Flux.interval(Duration.ofSeconds(2))
                .map(i -> db.toString());
    }
}
