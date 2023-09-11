package com.example.springwebflux.sec03;

import com.example.springwebflux.courseutil.Util;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lecture05 {

    public static void main(String[] args) {
        Flux.range(1,5)
                .delayElements(Duration.ofSeconds(3))
                .timeout(Duration.ofSeconds(2), fallback())
                .subscribe(Util.subscriber());

        Util.sleepSeconds(10);
    }

    private static Flux<Integer> fallback() {
        return Flux.range(100, 10)
                .delayElements(Duration.ofMillis(200));
    }
}
