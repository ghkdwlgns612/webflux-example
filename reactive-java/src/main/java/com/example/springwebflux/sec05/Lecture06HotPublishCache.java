package com.example.springwebflux.sec05;

import com.example.springwebflux.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lecture06HotPublishCache {
    // cache = publish().replay()
    public static void main(String[] args) {
        Flux<String> movieStream = Flux.fromStream(() -> getMovie())
                .delayElements(Duration.ofSeconds(1))
                .cache(2);

        Util.sleepSeconds(2);

        movieStream.subscribe(Util.subscriber("sam"));

        Util.sleepSeconds(10);

        System.out.println("Mike is about to join");
        movieStream.subscribe(Util.subscriber("mike"));

        movieStream.subscribe(Util.subscriber("mike1"));

        Util.sleepSeconds(60);
    }

    private static Stream<String> getMovie() {
        System.out.println("Got the movie streaming request");
        return Stream.of("Scene1", "Scene2", "Scene3", "Scene4", "Scene5", "Scene6", "Scene7", "Scene8");
    }
}
