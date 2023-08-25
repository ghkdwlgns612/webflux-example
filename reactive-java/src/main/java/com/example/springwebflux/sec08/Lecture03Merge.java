package com.example.springwebflux.sec08;

import com.example.springwebflux.courseutil.Util;
import com.example.springwebflux.sec08.helper.EmirateFlights;
import com.example.springwebflux.sec08.helper.QatarFlights;
import reactor.core.publisher.Flux;

public class Lecture03Merge {
    public static void main(String[] args) {

        final Flux<String> merge = Flux.merge(
                QatarFlights.getFlights(),
                EmirateFlights.getFlights(),
                EmirateFlights.getFlights()
        );
        merge.subscribe(Util.subscriber());

        Util.sleepSeconds(10);
    }
}
