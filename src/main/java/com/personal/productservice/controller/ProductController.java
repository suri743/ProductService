package com.personal.productservice.controller;

import com.personal.productservice.dto.ProductResponseDto;
import com.personal.productservice.models.Product;
import com.personal.productservice.service.FakeStoreProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final FakeStoreProductService fakeStoreProductService;

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable long id) {
        Product product = fakeStoreProductService.getProductById(String.valueOf(id));
        return new ResponseEntity<>(ProductResponseDto.from(product),HttpStatus.OK);
    }
}



