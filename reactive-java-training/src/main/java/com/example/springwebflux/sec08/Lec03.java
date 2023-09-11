package com.example.springwebflux.sec08;

import com.example.springwebflux.courseutil.Util;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

public class Lec03 {
    public static void main(String[] args) {
        getWelcomeMessage()
                .contextWrite(Context.of("user", "jake"))
                .contextWrite(Context.of("user", "sam"))
                .subscribe(Util.subscriber());
    }

    private static Mono<String> getWelcomeMessage() {
        return Mono.deferContextual(ctx -> {
            if (ctx.hasKey("user")) {
                return Mono.just("Welcome " + ctx.get("user"));
            } else {
                return Mono.error(new RuntimeException("Unauthenticated"));
            }
        });
    }

}
