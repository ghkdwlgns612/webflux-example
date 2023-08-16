package com.example.springwebflux.sec03;

import com.example.springwebflux.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lecture06FluxGenerateCounter {
    public static void main(String[] args) {
        Flux.generate(() -> 1, (counter, synchronousSink) -> {
                    String country = Util.faker().country().name();
                    synchronousSink.next(country);
                    if (counter >= 10 || country.equalsIgnoreCase("canada")) {
                        synchronousSink.complete();
                    }
                    return counter + 1;
                })
                .subscribe(Util.subscriber());
    }
}
