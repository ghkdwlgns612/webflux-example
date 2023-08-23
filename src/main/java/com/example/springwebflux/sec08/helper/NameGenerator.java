package com.example.springwebflux.sec08.helper;

import com.example.springwebflux.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class NameGenerator {

    private List<String> list = new ArrayList<>();

    public Flux<String> generateNames() {
        return Flux.generate(stringSynchronousSink -> {
            Util.sleepMillis(1);
            String name = Util.faker().name().fullName();
            list.add(name);
            stringSynchronousSink.next(name);
        })
                .cast(String.class)
                .startWith(getFromCache());
    }

    private Flux<String> getFromCache() {
        return Flux.fromIterable(list);
    }
}
