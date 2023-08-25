package com.example.springwebflux.sec04;

import com.example.springwebflux.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lecture06OnError {

    public static void main(String[] args) {
        Flux.range(1, 10)
                .log()
                .map(i -> 10 / (5 - i))
                .onErrorContinue((err, obj) -> {
                    System.out.println("Error is: " + err);
                    System.out.println("Object is: " + obj);
                })
                .subscribe(Util.subscriber());
    }

    private static Mono<Integer> fallback() {
        return Mono.fromSupplier(() -> Util.faker().random().nextInt(100, 200));
    }
}
