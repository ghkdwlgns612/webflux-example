package com.example.springwebflux.sec04;

import com.example.springwebflux.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class ColdPublisher {
    public static void main(String[] args) {
        Flux<String> movieStream = Flux.fromStream(() -> getMovie())
                .delayElements(Duration.ofSeconds(1))
                .publish()
                .autoConnect(0);

        movieStream.subscribe(Util.subscriber("sam"));
        Util.sleepSeconds(20);
        movieStream.subscribe(Util.subscriber("mike"));
        Util.sleepSeconds(60);
    }

    private static Stream<String> getMovie() {
        System.out.println("Got the movie streaming request");
        return Stream.of("Scene1", "Scene2", "Scene3", "Scene4", "Scene5", "Scene6", "Scene7", "Scene8");
    }
}
