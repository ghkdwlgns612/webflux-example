package com.example.springwebflux.sec03;

import com.example.springwebflux.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lecture02 {

    public static void main(String[] args) {

        Flux.create(fluxSink -> {
                    System.out.println("Inside create");
                    for (int i = 0; i < 5; i++) {
                        fluxSink.next(i);
                    }
                    fluxSink.complete();
                    System.out.println("Completed");
                })
                .doOnComplete(() -> System.out.println("doOnComplete"))
                .doFirst(() -> System.out.println("doFirst 1"))
                .doOnNext(o -> System.out.println("doOnNext: " + o))
                .doOnSubscribe(s -> System.out.println("doOnSubscribe: 1" + s))
                .doFirst(() -> System.out.println("doFirst 2"))
                .doOnRequest(l -> System.out.println("doOnRequest: " + l))
                .doOnSubscribe(s -> System.out.println("doOnSubscribe: 2" + s))
                .doOnError(err -> System.out.println("doOnError: " + err.getMessage()))
                .doOnTerminate(() -> System.out.println("doOnTerminate"))
                .doOnCancel(() -> System.out.println("doOnCancel"))
                .doFinally(signal -> System.out.println("doFinally: 1" + signal))
                .doFirst(() -> System.out.println("doFirst 3"))
                .take(2)
                .doFinally(signal -> System.out.println("doFinally: 2" + signal))
                .doOnDiscard(Object.class, o -> System.out.println("doOnDiscard: " + o))
                .subscribe(Util.subscriber());
    }
}
