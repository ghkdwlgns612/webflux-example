package com.example.springwebflux.sec02;

import com.example.springwebflux.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lecture01 {

    public static void main(String[] args) {
        final Flux<Integer> just = Flux.just(1, 2, 3, 4);
        just.subscribe(i -> System.out.println("Subscriber1 : " + i));

        Util.sleepSeconds(2);
        just.subscribe(i -> System.out.println("Subscriber2 : " + i));
    }
}
