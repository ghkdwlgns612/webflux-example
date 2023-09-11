package com.example.productservicetraining.controller;

import com.example.productservicetraining.dto.Response;
import com.example.productservicetraining.service.ReactiveMathService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("reactive-math")
@RequiredArgsConstructor
public class ReactiveController {

    private final ReactiveMathService reactiveMathService;

    @GetMapping("table/{input}")
    public Flux<Response> multiplicationTable(@PathVariable int input) {
        return reactiveMathService.multiplicationTable(input);
    }

    @GetMapping(value = "table/{input}/stream" , produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Response> streamMultiplicationTable(@PathVariable int input) {
        return reactiveMathService.multiplicationTable(input);
    }

    @GetMapping("square/{input}/mono-error")
    public Mono<Response> monoError(@PathVariable int input) {
        return Mono.just(input)
                .handle(((integer, responseSynchronousSink) -> {
                    if (integer >= 10 && integer <= 20) {
                        responseSynchronousSink.next(integer);
                    } else {
                        responseSynchronousSink.error(new RuntimeException("integer"));
                    }
                }))
                .cast(Integer.class)
                .flatMap(this.reactiveMathService::findSquare);
    }

}
