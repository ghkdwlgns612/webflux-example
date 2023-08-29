package com.example.productservice.service;

import com.example.productservice.dto.ProductDto;
import com.example.productservice.repository.ProductRepository;
import com.example.productservice.util.EntityDtoUtl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Flux<ProductDto> getAll() {
        return this.repository.findAll()
                .map(EntityDtoUtl::toDto);
    }

    public Mono<ProductDto> getProductById(String id) {
        return this.repository.findById(id)
                .map(EntityDtoUtl::toDto);
    }

    public Flux<ProductDto> getProductsByPriceRange(int min, int max) {
        return this.repository.findByPriceBetween(Range.closed(min, max))
                .map(EntityDtoUtl::toDto);
    }

    public Mono<ProductDto> insertProduct(Mono<ProductDto> productDtoMono) {
        return productDtoMono
                .map(EntityDtoUtl::toEntity)
                .flatMap(this.repository::insert)
                .map(EntityDtoUtl::toDto);
    }

    public Mono<ProductDto> updateProduct(String id, Mono<ProductDto> productDtoMono) {
        return this.repository.findById(id)
                .flatMap(p -> productDtoMono
                        .map(EntityDtoUtl::toEntity)
                        .doOnNext(e -> e.setId(id))
                )
                .flatMap(this.repository::save)
                .map(EntityDtoUtl::toDto);
    }

    public Mono<Void> deleteProduct(String id) {
        return this.repository.deleteById(id);
    }
}
