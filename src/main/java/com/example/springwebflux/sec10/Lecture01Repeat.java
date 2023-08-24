package com.example.springwebflux.sec10;

import com.example.springwebflux.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

public class Lecture01Repeat {

    private static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) {
        getIntegers()
                .repeat(() -> atomicInteger.get() < 13)
                .subscribe(Util.subscriber());
    }

    private static Flux<Integer> getIntegers() {
        return Flux.range(1, 3)
                .doOnSubscribe(s -> System.out.println("--Subscribed"))
                .doOnComplete(() -> System.out.println("--Completed"))
                .map(i -> atomicInteger.getAndIncrement());
    }
}
