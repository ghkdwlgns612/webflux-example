package com.example.springwebflux.sec09;

import com.example.springwebflux.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lecture01Buffer {

    public static void main(String[] args) {
        eventStream()
                .bufferTimeout(3, Duration.ofSeconds(5))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(10);
    }

    private static Flux<String> eventStream() {
        return Flux.interval(Duration.ofMillis(10))
                .map(i -> "event" + i);
    }
}
