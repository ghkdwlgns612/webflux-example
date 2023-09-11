package com.example.springwebflux.sec06;

import com.example.springwebflux.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec02 {

    public static void main(String[] args) {
        System.setProperty("reactor.bufferSize.small", "16");

        Flux.create(fluxSink ->  {
            for (int i = 0; i < 501; i++) {
                fluxSink.next(i);
                System.out.println("Pushed: " + i);
                Util.sleepMillis(1);
            }
            fluxSink.complete();
        })
                .onBackpressureBuffer(2)
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(i -> {
                    Util.sleepMillis(10);
                })
                .subscribe(Util.subscriber());

        Util.sleepSeconds(10);
    }
}
