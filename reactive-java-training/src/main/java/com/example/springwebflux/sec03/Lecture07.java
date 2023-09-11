package com.example.springwebflux.sec03;

import com.example.springwebflux.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.function.Function;

public class Lecture07 {
    public static void main(String[] args) {
        Flux.range(1,10)
                .map(i -> new Person())
                .transform(applyFilterMap())
                .subscribe(Util.subscriber());
    }

    private static Function<Flux<Person>, Flux<Person>> applyFilterMap() {
        return flux -> flux.filter(person -> person.getAge() > 10)
                .doOnNext(person -> person.setName(person.getName().toUpperCase()));
    }
}
