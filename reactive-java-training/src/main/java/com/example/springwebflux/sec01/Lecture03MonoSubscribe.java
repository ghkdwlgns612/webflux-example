package com.example.springwebflux.sec01;

import reactor.core.publisher.Mono;

public class Lecture03MonoSubscribe {

    public static void main(String[] args) {
        Mono<Integer> mono = Mono.just("ball")
                .map(String::length)
                .map(l -> l/0);

        mono.subscribe(
                System.out::println,
                err -> System.out.println("error" + err.getMessage()),
                () -> System.out.println("complete")
        );
        System.out.println("end");
    }
}
