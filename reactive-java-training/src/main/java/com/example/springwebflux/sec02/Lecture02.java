package com.example.springwebflux.sec02;

import com.example.springwebflux.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Stream;

public class Lecture02 {

    public static void main(String[] args) {
//        List<String> strings = List.of("a","b","c");
//        final Flux<String> flux = Flux.fromIterable(strings);
//        flux.subscribe(i -> System.out.println("Subscriber1 : " + i));
//        flux.subscribe(i -> System.out.println("Subscriber2 : " + i));
//        flux.subscribe(i -> System.out.println("Subscriber3 : " + i));
//        final Flux<String> stringFlux = Flux.fromStream(Stream.of("a", "b", "c"));
//        stringFlux.subscribe(i -> System.out.println("Subscriber1 : " + i));
//        stringFlux.subscribe(i -> System.out.println("Subscriber2 : " + i));
//        stringFlux.subscribe(i -> System.out.println("Subscriber3 : " + i));
        Flux.range(2,5)
                .map(i -> Util.faker().name().fullName())
                .log()
                .subscribe(Util.subscriber());
    }
}
