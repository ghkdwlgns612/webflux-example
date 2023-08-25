package com.example.springwebflux.sec01;

import com.example.springwebflux.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lecture05MonoFromSupplier {

    public static void main(String[] args) {

        // use just only when you have data already
        final Mono<String> mono = Mono.just(getName());


//        Mono.fromSupplier(() -> getName())
//                .subscribe(Util.onNext());
    }

    private static String getName() {
        System.out.println("Generating name...");
        return Util.faker().name().fullName();
    }
}
