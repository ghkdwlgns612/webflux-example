package com.example.springwebflux.sec01;

import com.example.springwebflux.courseutil.Util;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SignalType;

import java.util.concurrent.CompletableFuture;

public class Lecture07 {

    public static void main(String[] args) {
        CompletableFuture<String> name = getName();
        Mono<String> mono = Mono.fromFuture(name)
                .doOnCancel(() -> System.out.println("cancel"))
                .doFinally(signal -> {
                    System.out.println("finally");
                })
                .doOnError(err -> System.out.println("error : " + err.getMessage()));
        Disposable subscription = mono.subscribe(
                value -> {
                    System.out.println("Received: " + value);
                }
        );
//        subscription.dispose();
        Util.sleepSeconds(1);
        System.out.println(name.isCancelled());
    }

    private static CompletableFuture<String> getName() {
        return CompletableFuture.supplyAsync(() -> {
            return Util.faker().name().fullName();
        });
    }
}
