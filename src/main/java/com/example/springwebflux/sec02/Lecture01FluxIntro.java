package com.example.springwebflux.sec02;

import com.example.springwebflux.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lecture01FluxIntro {
    public static void main(String[] args) {
//        final Flux<Integer> flux = Flux.just(1,2,3,4);
//        final Flux<Integer> flux = Flux.empty();
        final Flux<Object> flux = Flux.just(1,2,3,"a",Util.faker().name().fullName());

        flux.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete());
    }
}
