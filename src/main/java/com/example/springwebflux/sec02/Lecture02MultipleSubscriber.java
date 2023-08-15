package com.example.springwebflux.sec02;

import reactor.core.publisher.Flux;

public class Lecture02MultipleSubscriber {

    public static void main(String[] args) {
        final Flux<Integer> integerFlux = Flux.just(1, 2, 3, 4);

        final Flux<Integer> evenFlux = integerFlux.filter(i -> i % 2 == 0);

        integerFlux.subscribe(i -> System.out.println("Subscriber 1: " + i));
        evenFlux.subscribe(i -> System.out.println("Subscriber 2: " + i));
    }
}
