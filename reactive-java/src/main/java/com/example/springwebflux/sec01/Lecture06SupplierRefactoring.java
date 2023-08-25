package com.example.springwebflux.sec01;

import com.example.springwebflux.courseutil.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class Lecture06SupplierRefactoring {

    public static void main(String[] args) {
        getName();
        getName()
                .subscribeOn(Schedulers.boundedElastic())
                .block();
        getName();
    }

    private static Mono<String> getName() {
        System.out.println("entered getName method");
        return Mono.fromSupplier(() -> {
            System.out.println("Generating name...");
            Util.sleepSeconds(3);
            return Util.faker().name().fullName();
        }).map(String::toUpperCase);
    }
}
