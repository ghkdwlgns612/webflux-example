package com.example.springwebflux.sec08;

import com.example.springwebflux.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lecture04Zip {

    public static void main(String[] args) {
        Flux.zip(getBody(), getEngine(), getTires())
                .subscribe(Util.subscriber());

        Util.sleepSeconds(10);
    }

    private static Flux<String> getBody() {
        return Flux.range(1, 5)
                .delayElements(Duration.ofSeconds(1))
                .map(i -> "body");
    }
    private static Flux<String> getEngine() {
        return Flux.range(1, 2)
                .map(i -> "engine");
    }
    private static Flux<String> getTires() {
        return Flux.range(1, 6)
                .map(i -> "tire");
    }

}
