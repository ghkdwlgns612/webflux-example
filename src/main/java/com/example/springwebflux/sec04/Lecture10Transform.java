package com.example.springwebflux.sec04;

import com.example.springwebflux.courseutil.Util;
import com.example.springwebflux.sec04.helper.Person;
import reactor.core.publisher.Flux;

import java.util.function.Function;

public class Lecture10Transform {

    public static void main(String[] args) {
        getPerson()
                .transform(applyFilterMap())
                .subscribe(Util.subscriber());
    }

    public static Flux<Person> getPerson() {
        return Flux.range(1, 10)
                .map(i -> new Person());
    }

    public static Function<Flux<Person>, Flux<Person>> applyFilterMap() {
        return flux -> flux.filter(person -> person.getAge() > 10)
                .doOnNext(person -> person.setName(person.getName().toUpperCase()))
                .doOnDiscard(Person.class, person -> System.out.println("Not allowing : " + person));
    }
}
