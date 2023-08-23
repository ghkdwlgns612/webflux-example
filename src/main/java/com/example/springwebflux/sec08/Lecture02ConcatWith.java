package com.example.springwebflux.sec08;

import com.example.springwebflux.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lecture02ConcatWith {
    public static void main(String[] args) {
        final Flux<String> flux1 = Flux.just("A", "B", "C");
        final Flux<String> flux2 = Flux.error(new RuntimeException("oops"));
        final Flux<String> flux3 = Flux.just("D", "E");

        Flux.concatDelayError(flux1, flux2, flux3)
                .subscribe(Util.subscriber());
    }
}
