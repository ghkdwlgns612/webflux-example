package com.example.springwebflux.sec03;

import com.example.springwebflux.courseutil.Util;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

public class Lecture06 {

    public static void main(String[] args) {
        Flux.range(10,5)
                .filter(i -> i < 10)
                .switchIfEmpty(getPublisher())
                .subscribe(Util.subscriber());
    }

    private static Publisher<Integer> getPublisher() {
        return Flux.range(1,10);
    }
}
