package com.example.springwebflux.sec05;

import com.example.springwebflux.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lecture05HotPublishAutoConnect {

    public static void main(String[] args) {
        // share = publish().refCount(1)
        Flux<String> movieStream = Flux.fromStream(() -> getMovie())
                .delayElements(Duration.ofSeconds(1))
                .publish()
                .autoConnect(0);

        Util.sleepSeconds(3);

        movieStream.subscribe(Util.subscriber("sam"));

        Util.sleepSeconds(10);

        System.out.println("Mike is about to join");
        movieStream.subscribe(Util.subscriber("mike"));

        Util.sleepSeconds(60);
    }

    private static Stream<String> getMovie() {
        System.out.println("Got the movie streaming request");
        return Stream.of("Scene1", "Scene2", "Scene3", "Scene4", "Scene5", "Scene6", "Scene7", "Scene8");
    }
}
