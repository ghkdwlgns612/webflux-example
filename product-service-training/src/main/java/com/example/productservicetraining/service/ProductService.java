package com.example.productservicetraining.service;

import com.example.productservicetraining.dto.ProductDto;
import com.example.productservicetraining.repository.ProductRepository;
import com.example.productservicetraining.util.EntityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Flux<ProductDto> getAll() {
        return productRepository.findAll()
                .map(EntityUtil::toDto);
    }

    public Mono<ProductDto> createProduct(Mono<ProductDto> productDtoMono) {
        return productDtoMono
                .map(EntityUtil::toEntity)
                .flatMap(this.productRepository::insert)
                .map(EntityUtil::toDto);
    }

    public Mono<ProductDto> updateProduct(String id, Mono<ProductDto> productDtoMono) {
        return productRepository.findById(id)
                .flatMap(p -> productDtoMono
                        .map(EntityUtil::toEntity)
                        .doOnNext(e -> e.setId(id))
                )
                .flatMap(this.productRepository::save)
                .map(EntityUtil::toDto);
    }

    public Mono<ProductDto> deleteProduct(String id) {
        return productRepository.findById(id)
                .doOnNext(this.productRepository::delete)
                .map(EntityUtil::toDto);
    }

    public Flux<ProductDto> betweenPrice(int min, int max) {
        return productRepository.findAllByPriceBetween(min, max)
                .map(EntityUtil::toDto);
    }
}
