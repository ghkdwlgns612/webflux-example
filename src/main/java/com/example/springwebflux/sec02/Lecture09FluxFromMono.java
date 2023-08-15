package com.example.springwebflux.sec02;

import com.example.springwebflux.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lecture09FluxFromMono {

    public static void main(String[] args) {
//        Mono<String> mon = Mono.just("a");
//
//        Flux.from(mon)
//                .subscribe(Util.onNext());

        Flux.range(1,10)
                .next()
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());
    }
}
