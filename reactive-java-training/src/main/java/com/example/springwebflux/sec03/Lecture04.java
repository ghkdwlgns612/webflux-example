package com.example.springwebflux.sec03;

import com.example.springwebflux.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.function.BiConsumer;

public class Lecture04 {
    public static void main(String[] args) {
//        Flux.range(1, 10)
//                .log()
//                .map(i -> 10 / (5 - i))
//                .onErrorReturn(ArithmeticException.class, -1)
//                .subscribe(Util.subscriber());
        Flux.range(1, 10)
                .log()
                .map(i -> 10 / (5 - i))
                .onErrorContinue(getError())
                .subscribe(Util.subscriber());

    }

    private static BiConsumer<Throwable, Object> getError() {
        return (err, obj) -> {
            System.out.println("Error is: " + err);
            System.out.println("Object is: " + obj);
        };
    }

}
