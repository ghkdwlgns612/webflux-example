package com.example.springwebflux.sec03;

import com.example.springwebflux.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.util.function.BiConsumer;

public class Lecture01 {
    public static void main(String[] args) {
        Flux.generate(synchronousSink -> synchronousSink.next(Util.faker().country().name()))
                .map(Object::toString)
                .handle(getCanada())
                .subscribe(Util.subscriber());
    }

    private static BiConsumer<String, SynchronousSink<String>> getCanada() {
        return (country, synchronousSink) -> {
            synchronousSink.next(country);
            if (country.toLowerCase().equals("canada")) {
                synchronousSink.complete();
            }
        };
    }
}
