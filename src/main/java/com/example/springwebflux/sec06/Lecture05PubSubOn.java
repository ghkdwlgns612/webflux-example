package com.example.springwebflux.sec06;

import com.example.springwebflux.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lecture05PubSubOn {

    public static void main(String[] args) {
        Flux<Object> flux = Flux.create(fluxSink -> {
                    printThreadName("create");
                    for (int i = 0; i < 2; i++) {
                        fluxSink.next(i);
                        Util.sleepSeconds(1);
                    }
                    fluxSink.complete();
                })
                .doOnNext(i -> printThreadName("next " + i));

        flux
                .publishOn(Schedulers.parallel())
                .doOnNext(i -> printThreadName("next " + i))
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(v -> printThreadName("sub " + v));

        Util.sleepSeconds(10);
    }

    private static void printThreadName(String msg) {
        System.out.println(msg + "\t\t: Thread : " + Thread.currentThread().getName());
    }
}
