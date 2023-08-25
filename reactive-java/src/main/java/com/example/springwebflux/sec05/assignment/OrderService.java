package com.example.springwebflux.sec05.assignment;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class OrderService {
    public static Flux<Order> getOrders() {
        return Flux.fromStream(() -> getOrderList())
                .delayElements(Duration.ofSeconds(1))
                .share();
    }

    private static Stream<Order> getOrderList() {
        System.out.println("Got the movie streaming request");
        return Stream.of(
                new Order("1", "item1", 10.0),
                new Order("2", "item2", 20.0),
                new Order("3", "item3", 30.0),
                new Order("4", "item4", 40.0),
                new Order("5", "item5", 50.0),
                new Order("6", "item6", 60.0),
                new Order("7", "item7", 70.0),
                new Order("8", "item8", 80.0)
        );
    }
}
