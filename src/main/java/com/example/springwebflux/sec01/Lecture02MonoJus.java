package com.example.springwebflux.sec01;

import reactor.core.publisher.Mono;

public class Lecture02MonoJus {

    public static void main(String[] args) {
        //publisher
        Mono<Integer> mono = Mono.just(1);

        System.out.println(mono);

        mono.subscribe(i -> System.out.println("Recieved : " + i));
    }
}
