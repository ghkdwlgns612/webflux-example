package com.example.springwebflux.sec03;

import com.example.springwebflux.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lecture04FluxCreateIssueFix {

    public static void main(String[] args) {
        Flux.create(fluxSink -> {
                    String country;
                    do {
                        country = Util.faker().country().name();
                        System.out.println("Emitting: " + country);
                        fluxSink.next(country);
                    } while (!country.equalsIgnoreCase("canada") && !fluxSink.isCancelled());
                    fluxSink.complete();
                })
                .take(3)
                .subscribe(Util.subscriber());
    }
}
