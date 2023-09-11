package com.example.springwebflux.sec01;

import com.example.springwebflux.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lecture05MonoFromSupplier {

    public static void main(String[] args) {
        Mono.fromSupplier(() -> getName());
    }

    private static String getName() {
        System.out.println("Generation name...");
        return Util.faker().name().fullName();
    }
}
