package com.example.productservicetraining.controller;

import com.example.productservicetraining.dto.ProductDto;
import com.example.productservicetraining.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("all")
    public Flux<ProductDto> getAll() {
        return productService.getAll();
    }

    @GetMapping("price-range")
    public Flux<ProductDto> betweenPrice(@RequestParam int min,
                                         @RequestParam int max) {
        return this.productService.betweenPrice(min, max);
    }

    @PostMapping
    public Mono<ProductDto> createProduct(@RequestBody Mono<ProductDto> dto) {
        return productService.createProduct(dto);
    }

    @PutMapping("{id}")
    public Mono<ProductDto> updateProduct(@PathVariable String id,
                                          @RequestBody Mono<ProductDto> dto) {
        return productService.updateProduct(id, dto);
    }

    @DeleteMapping("{id}")
    public Mono<ProductDto> deleteProduct(@PathVariable String id) {
        return productService.deleteProduct(id);
    }
}
