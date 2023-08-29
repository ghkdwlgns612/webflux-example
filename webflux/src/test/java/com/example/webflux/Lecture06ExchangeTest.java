package com.example.webflux;

import com.example.webflux.dto.InputFailedValidationResponse;
import com.example.webflux.dto.Response;
import com.example.webflux.exception.InputValidationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class Lecture06ExchangeTest extends BaseTest {
    @Autowired
    private WebClient webClient;

    //exchange = retrieve + additional info http status code
    @Test
    void badRequestTest() {
        Mono<Object> responseMono = this.webClient
                .get()
                .uri("/reactive-math/square/{number}/throw", 5)
                .exchangeToMono(this::exchangeToMono)
                .doOnNext(System.out::println)
                .doOnError(e -> System.out.println(e.getMessage()));//Mono<Response>

        StepVerifier.create(responseMono)
                .verifyError(InputValidationException.class);
    }

    private Mono<Object> exchangeToMono(ClientResponse response) {
        if (response.statusCode() == HttpStatus.BAD_REQUEST) {
            return response.bodyToMono(InputFailedValidationResponse.class);
        } else {
            return response.bodyToMono(Response.class);
        }
    }
}
