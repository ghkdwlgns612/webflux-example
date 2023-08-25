package com.example.springwebflux.sec04;

import com.example.springwebflux.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lecture04LimitRate {

    public static void main(String[] args) {

        Flux.range(1,1000)
                .log()
                .limitRate(100)
                .subscribe(Util.subscriber());

    }
}
