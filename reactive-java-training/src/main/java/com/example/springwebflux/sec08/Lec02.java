package com.example.springwebflux.sec08;

import com.example.springwebflux.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.util.retry.Retry;

public class Lec02 {
    public static void main(String[] args) {
        getIntegers()
                .retry(2)
                .subscribe(Util.subscriber());
    }

    private static Flux<Integer> getIntegers() {
        return Flux.range(1, 3)
                .doOnSubscribe(s -> System.out.println("--Subscribed"))
                .doOnComplete(() -> System.out.println("--Completed"));
    }

}
