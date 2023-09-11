package com.example.springwebflux.sec01;

import com.example.springwebflux.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lecture04MonoEmptyOrError {

    public static void main(String[] args) {
        userRepository(3)
                .subscribe(
                        item -> System.out.println("Receive : " + item),
                        err -> System.out.println("Error : " + err.getMessage()),
                        () -> System.out.println("Completed")
                );
    }

    private static Mono<String> userRepository(int userId) {
        if (userId == 1) {
            return Mono.empty();
        } else if (userId == 2) {
            return Mono.just(Util.faker().name().firstName());
        } else {
            return Mono.error(new RuntimeException("error RuntimeException"));
        }
    }
}
