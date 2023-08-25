package com.example.springwebflux.sec04;

import com.example.springwebflux.sec04.helper.Person;
import reactor.core.publisher.Flux;

import java.util.function.Function;

public class Lecture11SwitchOnFirst {

    public static void main(String[] args) {
        Flux<Integer> integerFlux = Flux.just(2, 3, 3, 4, 5, 6, 7);
        integerFlux
                .switchOnFirst((signal, flux) -> signal.get() == 2 ? flux : Flux.empty())
                .defaultIfEmpty(100)
                .subscribe(System.out::println);
/*        getPerson()
                .switchOnFirst((signal, personFlux) -> {
                    System.out.println("inside switch on first");
                    return signal.isOnNext() && signal.get().getAge() > 10 ? personFlux : applyFilterMap().apply(personFlux);
                })
                .subscribe(Util.subscriber());*/
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
