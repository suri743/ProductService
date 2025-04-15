package com.personal.productservice.controller;

import com.personal.productservice.dto.CreateFakeStoreProductDto;
import com.personal.productservice.dto.ProductResponseDto;
import com.personal.productservice.models.Product;
import com.personal.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable long id) {
        Product product = productService.getProductById(String.valueOf(id));
        return new ResponseEntity<>(ProductResponseDto.from(product),HttpStatus.OK);
    }

    @GetMapping("/products")
    public List<ProductResponseDto> getAllProducts() {

        return productService.getAllProducts()
            .stream().map(ProductResponseDto::from)
            .collect(Collectors.toList());
    }

    @PostMapping("/products")
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody CreateFakeStoreProductDto createFakeStoreProductDto) {

        Product product = productService.createProduct(createFakeStoreProductDto.getName(),
                                                       createFakeStoreProductDto.getDescription(),
                                                       createFakeStoreProductDto.getPrice(),
                                                       createFakeStoreProductDto.getImageUrl(),
                                                       createFakeStoreProductDto.getCategory());

        return new ResponseEntity<>(ProductResponseDto.from(product),HttpStatus.OK);
    }
}



