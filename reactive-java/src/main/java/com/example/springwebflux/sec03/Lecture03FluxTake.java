package com.example.springwebflux.sec03;

import com.example.springwebflux.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lecture03FluxTake {

    public static void main(String[] args) {
        // map

        // filter
        Flux.range(1,10)
                .log()
                .take(3)
                .log()
                .subscribe(Util.subscriber());
    }
}
