package com.example.springwebflux.sec03;

import com.example.springwebflux.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lecture01FluxCreate {

    public static void main(String[] args) {
        Flux.create(fluxSink -> {
                    fluxSink.next(1);
                    fluxSink.next(2);
                    fluxSink.next(3);
                    fluxSink.next(4);
                    fluxSink.complete();
                })
                .subscribe(Util.subscriber());

        Flux.create(fluxSink -> {
                    String country;
                    do {
                        country = Util.faker().country().name();
                        fluxSink.next(country);
                    } while (!country.equalsIgnoreCase("canada"));
                    fluxSink.complete();
                })
                .subscribe(Util.subscriber());

    }
}
