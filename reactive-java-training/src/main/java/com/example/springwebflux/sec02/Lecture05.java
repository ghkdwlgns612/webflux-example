package com.example.springwebflux.sec02;

import com.example.springwebflux.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lecture05 {
    public static void main(String[] args) {
        Flux.create(fluxSink -> {
                    for (int i = 0; i < 100; i++) {
                        fluxSink.next(i);
                        Util.sleepMillis(100);
                    }
                    fluxSink.next(2);
                    fluxSink.next(3);
                    fluxSink.next(4);
                    fluxSink.next(5);
                })
                .subscribe(Util.subscriber());
    }
}
