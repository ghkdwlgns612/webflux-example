package com.example.springwebflux.sec09;

import com.example.springwebflux.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lecture02OverlapAndDrop {
    public static void main(String[] args) {
        eventStream()
                .buffer(3,5)
                .subscribe(Util.subscriber());

        Util.sleepSeconds(10);
    }

    private static Flux<String> eventStream() {
        return Flux.interval(Duration.ofMillis(300))
                .map(i -> "event" + i);
    }
}
