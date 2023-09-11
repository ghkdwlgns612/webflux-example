package com.example.springwebflux.sec08;

import com.example.springwebflux.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec01 {
    public static void main(String[] args) {
        eventStream()
                .window(5)
                .delayElements(Duration.ofSeconds(3))
                .doOnNext(i -> {
                    i
                            .doOnNext(System.out::println)
                            .subscribe(Util.subscriber());

                })
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }

    private static Flux<String> eventStream() {
        return Flux.interval(Duration.ofMillis(500))
                .map(i -> "event" + i);
    }
}
