package com.example.springwebflux.sec06;

import com.example.springwebflux.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

public class Lecture07FluxInterval {

    public static void main(String[] args) {
        Flux.interval(Duration.ofSeconds(1))
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(Util.subscriber());

        Util.sleepSeconds(5);
    }
}
