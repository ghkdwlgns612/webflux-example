package com.example.productservicetraining.util;

import com.example.productservicetraining.dto.ProductDto;
import com.example.productservicetraining.entity.Product;
import org.springframework.beans.BeanUtils;

public class EntityUtil {

    public static ProductDto toDto(Product product) {
        ProductDto dto = new ProductDto();
        BeanUtils.copyProperties(product, dto);
        return dto;
    }

    public static Product toEntity(ProductDto productDtoMono) {
        Product product = new Product();
        BeanUtils.copyProperties(productDtoMono, product);
        return product;
    }
}
