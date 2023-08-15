package com.example.springwebflux.sec02;

import com.example.springwebflux.courseutil.Util;
import com.example.springwebflux.sec02.helper.NameGenerator;
import reactor.core.publisher.Flux;

import java.util.List;

public class Lecture07FluxVsList {
    public static void main(String[] args) {
        NameGenerator.getNames(5)
                .subscribe(Util.onNext());
    }
}
