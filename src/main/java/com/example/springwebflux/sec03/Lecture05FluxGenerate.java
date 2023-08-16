package com.example.springwebflux.sec03;

import com.example.springwebflux.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lecture05FluxGenerate {
    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
                    String country = Util.faker().country().name();
                    synchronousSink.next(country);
                    if (country.equalsIgnoreCase("canada")) {
                        synchronousSink.complete();
                    }
                })
                .subscribe(Util.subscriber());
    }
}
