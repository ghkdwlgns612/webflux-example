package com.example.springwebflux.sec02;

import com.example.springwebflux.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class Lecture06 {

    public static void main(String[] args) {
//        Flux.range(0, 10)
//                .log()
//                .take(3)
//                .subscribe(Util.subscriber());
//
//        final Flux<Object> canada = Flux.create(fluxSink -> {
//            String country;
//            do {
//                country = Util.faker().country().name();
//                fluxSink.next(country);
//            } while (!fluxSink.isCancelled() && !country.equalsIgnoreCase("canada"));
//            fluxSink.complete();
//        });
//
//        canada.delayElements(Duration.ofSeconds(2)).subscribe(i -> System.out.println("Sub1 : " + i));
//        canada.delayElements(Duration.ofSeconds(4)).subscribe(i -> System.out.println("Sub2 : " + i));


//        Flux<Integer> integerFlux = Flux.generate(fluxSink -> {
//            IntStream.range(0, 5)
//                    .peek(i -> System.out.println("going to emit - " + i))
//                    .forEach(fluxSink::next);
//        });
//        integerFlux.delayElements(Duration.ofMillis(1)).subscribe(i -> System.out.println("First :: " + i));
//        integerFlux.delayElements(Duration.ofMillis(2)).subscribe(i -> System.out.println("Second:: " + i));


//        Flux<Integer> integerFlux = Flux.create((FluxSink<Integer> fluxSink) -> {
//            System.out.println("Flux create");
//            IntStream.range(0, 100)
//                    .peek(i -> System.out.println("going to emit - " + i))
//                    .forEach(fluxSink::next);
//        });
//        integerFlux.delayElements(Duration.ofMillis(50))
//                .subscribe(i -> {
//                    System.out.println("First consumed ::" + i);
//                });

        AtomicInteger atomicInteger = new AtomicInteger();

        //Flux generate sequence
        Flux<Integer> integerFlux = Flux.generate((SynchronousSink<Integer> synchronousSink) -> {
            System.out.println("Flux generate");
            synchronousSink.next(atomicInteger.getAndIncrement());
        });

        //observer
        integerFlux.delayElements(Duration.ofMillis(200))
                .subscribe(i -> System.out.println("First consumed ::" + i));
        Util.sleepSeconds(60);
    }
}
