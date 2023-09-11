package com.example.productservicetraining.config;

import com.example.productservicetraining.dto.Response;
import com.example.productservicetraining.service.ReactiveMathService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class RequestHandler {

    private final ReactiveMathService mathService;

    public Mono<ServerResponse> squareHandler(ServerRequest request) {
        Integer input = Integer.parseInt(request.pathVariable("input"));
        Mono<Response> responseMono = this.mathService.findSquare(input);
        return ServerResponse.ok().body(responseMono, Response.class);
    }

    public Mono<ServerResponse> squareHandlerWithValidation(ServerRequest request) {
        int input = Integer.parseInt(request.pathVariable("input"));
        if (input < 10 || input > 20) {
            return Mono.error(new RuntimeException("error : " + input));
        }
        Mono<Response> responseMono = this.mathService.findSquare(input);
        return ServerResponse.ok().body(responseMono, Response.class);
    }
}
