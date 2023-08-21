package com.example.springwebflux.sec04;

import com.example.springwebflux.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lecture07Timeout {

    public static void main(String[] args) {
        getOrderNumbers()
                .timeout(Duration.ofSeconds(2), fallback())
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }

    private static Flux<Integer> getOrderNumbers() {
        return Flux.range(1, 5)
                .delayElements(Duration.ofSeconds(5));
    }

    private static Flux<Integer> fallback() {
        return Flux.range(100, 10)
                .delayElements(Duration.ofMillis(200));
    }
}
