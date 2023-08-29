package com.example.webflux;

import com.example.webflux.dto.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class Lecture05BadRequestTest extends BaseTest {
    @Autowired
    private WebClient webClient;

    @Test
    void badRequestTest() {
        Mono<Response> responseMono = this.webClient
                .get()
                .uri("/reactive-math/square/{number}/throw", 5)
                .retrieve()
                .bodyToMono(Response.class)
                .doOnNext(System.out::println)
                .doOnError(e -> System.out.println(e.getMessage()));//Mono<Response>

        StepVerifier.create(responseMono)
                .verifyError(WebClientResponseException.BadRequest.class);
    }
}
