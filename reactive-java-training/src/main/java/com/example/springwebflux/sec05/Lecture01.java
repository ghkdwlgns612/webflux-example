package com.example.springwebflux.sec05;

import com.example.springwebflux.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lecture01 {
    public static void main(String[] args) {
        final Flux<Object> flux = Flux.create(fluxSink -> {
                    printThread("create");
                    fluxSink.next(1);
                })
                .doOnNext(i -> printThread("next " + i));

        for (int i = 0; i < 100; i++) {
            flux
                    .doFirst(() -> printThread(""))
                    .subscribeOn(Schedulers.parallel())
                    .subscribe(v -> printThread("g"));
        }
//        flux
//                .doFirst(() -> printThread("first3"))
//                .subscribeOn(Schedulers.boundedElastic())
//                .doFirst(() -> printThread("first2"))
//                .subscribeOn(Schedulers.boundedElastic())
//                .doFirst(() -> printThread("first1"))
//                .subscribe(v -> printThread("sub " + v));

        Util.sleepSeconds(5);
    }

    private static void printThread(String msg) {
        System.out.println(msg + "\t\t: Thread : " + Thread.currentThread().getName());
    }
}
