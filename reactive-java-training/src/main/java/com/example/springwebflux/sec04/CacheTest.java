package com.example.springwebflux.sec04;

import com.example.springwebflux.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class CacheTest {

    public static void main(String[] args) {
        final Flux<String> cache = Flux.fromStream(() -> getMovie())
                .delayElements(Duration.ofSeconds(1))
                .cache(3);

        Util.sleepSeconds(2);
        cache.subscribe(Util.subscriber("sam"));
        Util.sleepSeconds(5);
        cache.subscribe(Util.subscriber("mike"));
        Util.sleepSeconds(60);
    }

    private static Stream<String> getMovie() {
        System.out.println("Got the movie streaming request");
        return Stream.of("Scene1", "Scene2", "Scene3", "Scene4", "Scene5", "Scene6", "Scene7", "Scene8");
    }
}
