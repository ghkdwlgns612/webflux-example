package com.example.springwebflux.sec03;

import com.example.springwebflux.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lecture03 {

    public static void main(String[] args) {
        Flux.range(1,1000)
                .log()
                .limitRate(150)
                .subscribe(Util.subscriber());
    }
}
