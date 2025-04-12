package com.personal.productservice.service;

import com.personal.productservice.dto.FakeStoreProductDto;
import com.personal.productservice.models.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class FakeStoreProductService implements ProductService {

    private final RestTemplate restTemplate;

    @Override
    public Product getProductById(String id) {
        FakeStoreProductDto fakeStoreProductDto =
            restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);

        if (fakeStoreProductDto == null) {
            return null;
        }
        return fakeStoreProductDto.toProduct();
    }
}
