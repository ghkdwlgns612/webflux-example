package com.example.springwebflux.sec09;

import com.example.springwebflux.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lecture05Group {

    public static void main(String[] args) {
        Flux.range(1,30)
                .delayElements(Duration.ofSeconds(1))
                .groupBy(i -> i % 3) // key : 0, 1
                .subscribe(gf -> process(gf, gf.key()));

        Util.sleepSeconds(60);
    }

    private static void process(Flux<Integer> flux, int key) {
        System.out.println("Called");
        flux.subscribe(i -> System.out.println("key: " + key + ", item: " + i));
    }
}
