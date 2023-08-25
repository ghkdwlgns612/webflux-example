package com.example.springwebflux.sec02;

import com.example.springwebflux.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Stream;

public class Lecture04FluxFromStream {

    public static void main(String[] args) {

        final List<Integer> integers = List.of(1, 2, 3, 4, 5);

        final Stream<Integer> stream = integers.stream();

        Flux.fromStream(() -> integers.stream())
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );

        Flux.fromStream(() -> integers.stream())
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );
    }

}
