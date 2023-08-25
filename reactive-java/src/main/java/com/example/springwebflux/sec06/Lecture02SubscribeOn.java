package com.example.springwebflux.sec06;

import com.example.springwebflux.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lecture02SubscribeOn {

    public static void main(String[] args) {
        Flux<Object> flux = Flux.create(fluxSink -> {
                    printThreadName("create");
                    fluxSink.next(1);
                })
                .subscribeOn(Schedulers.newParallel("vins"))
                .doOnNext(i -> printThreadName("next " + i));

        flux
                .doFirst(() -> printThreadName("first2"))
                .subscribeOn(Schedulers.boundedElastic())
                .doFirst(() -> printThreadName("first1"))
                .subscribe(v -> printThreadName("sub " + v));

        Util.sleepSeconds(5);
    }

    private static void printThreadName(String msg) {
        System.out.println(msg + "\t\t: Thread : " + Thread.currentThread().getName());
    }

}
