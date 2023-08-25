package com.example.springwebflux.sec03;

import com.example.springwebflux.courseutil.Util;
import com.example.springwebflux.sec03.helper.NameProducer;
import reactor.core.publisher.Flux;

public class Lecture08FluxPush {
    public static void main(String[] args) {
        NameProducer nameProducer = new NameProducer();

        Flux.push(nameProducer)
                .subscribe(Util.subscriber());
    }
}
