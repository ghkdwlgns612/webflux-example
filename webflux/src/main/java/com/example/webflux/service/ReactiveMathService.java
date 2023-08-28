package com.example.webflux.service;

import com.example.webflux.dto.MultiplyRequestDto;
import com.example.webflux.dto.Response;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ReactiveMathService {

    public Mono<Response> findSquare(int input) {
        return Mono.fromSupplier(() -> input * input)
                .map(Response::new);
    }

    public Flux<Response> multiplicationTable(int input) {
        return Flux.range(1, 10)
                .doOnNext(i -> System.out.println("reactive-math-service processing: " + i))
                .doOnNext(i -> SleepUtil.sleepSeconds(1))
//                .delayElements(java.time.Duration.ofSeconds(1))
                .map(i -> new Response(i * input));
    }

    public Mono<Response> multiply(Mono<MultiplyRequestDto> dtoMono) {
        return dtoMono
                .map(dto -> dto.getFirst() * dto.getSecond())
                .map(Response::new);
    }
}
