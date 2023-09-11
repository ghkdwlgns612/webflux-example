package com.example.springwebflux.sec03;

import com.example.springwebflux.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lecture08 {
    public static void main(String[] args) {
        Flux.create(fluxSink -> {
                    fluxSink.next(1);
                    fluxSink.next(1);
                    fluxSink.next(1);
                    fluxSink.next(1);

                })
                .map(i -> Util.faker().name())
                .subscribe(Util.subscriber());
    }
}
