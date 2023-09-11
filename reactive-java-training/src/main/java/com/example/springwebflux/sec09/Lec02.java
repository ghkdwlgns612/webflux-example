package com.example.springwebflux.sec09;

import com.example.springwebflux.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class Lec02 {

    public static void main(String[] args) {
        Sinks.Many<Object> sink = Sinks.many().unicast().onBackpressureBuffer();

        final Flux<Object> flu = sink.asFlux();

        flu.subscribe(Util.subscriber("sam"));
        flu.subscribe(Util.subscriber("mike"));

    }
}
