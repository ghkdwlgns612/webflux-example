package com.example.springwebflux.sec02;

import com.example.springwebflux.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class Lecture03FluxFromArrayOrList {

    public static void main(String[] args) {

        final List<String> strings = Arrays.asList("a", "b", "c");
        Flux.fromIterable(strings)
                .subscribe(Util.onNext());

        Integer[] integers = {1, 2, 3, 4};
        Flux.fromArray(integers)
                .subscribe(Util.onNext());
    }
}
