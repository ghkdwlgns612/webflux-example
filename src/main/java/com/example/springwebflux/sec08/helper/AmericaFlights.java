package com.example.springwebflux.sec08.helper;

import com.example.springwebflux.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class AmericaFlights {

    public static Flux<String> getFlights() {
        return Flux.range(1, Util.faker().random().nextInt(1,5))
                .delayElements(Duration.ofSeconds(1))
                .map(i -> "America" + Util.faker().random().nextInt(100, 999))
                .filter(i -> Util.faker().random().nextBoolean());

    }

}
