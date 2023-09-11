package com.example.springwebflux.sec01;

import reactor.core.publisher.Mono;

public class Lecture02MonoJust {
    public static void main(String[] args) {
        Mono<Integer> just = Mono.just(1);
        System.out.println(just);
        just.subscribe(System.out::println);
    }
}
