package com.example.springwebflux.sec01;

import com.example.springwebflux.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lecture03MonoSubscribe {

    public static void main(String[] args) {

//        final Mono<String> mono = Mono.just("ball");
        final Mono<Integer> mono = Mono.just("ball")
                .map(String::length)
                .map(l -> l/1);

        mono.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }
}
