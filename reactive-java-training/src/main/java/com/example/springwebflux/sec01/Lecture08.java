package com.example.springwebflux.sec01;

import com.example.springwebflux.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lecture08 {

    public static void main(String[] args) {
        Mono.fromRunnable(runnable())
                .subscribe(Util.subscriber());
    }

    private static Runnable runnable() {
        return () -> {
            Util.sleepSeconds(3);
            System.out.println("Runnable");
        };
    }

}
