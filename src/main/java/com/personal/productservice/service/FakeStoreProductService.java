package com.personal.productservice.service;

import com.personal.productservice.dto.FakeStoreProductDto;
import com.personal.productservice.dto.FakeStoreProductRequestDto;
import com.personal.productservice.models.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] fakeStoreProductDtos =
            restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDto[].class);

        List<Product> products = new ArrayList<>();
        if (fakeStoreProductDtos != null) {
            for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
                products.add(fakeStoreProductDto.toProduct());
            }
        }
        return products;
    }

    @Override
    public Product createProduct(String productName, String productDescription, Double productPrice,
                                 String productImageUrl, String productCategory) {

        FakeStoreProductRequestDto fakeStoreProductRequestDto =
            FakeStoreProductRequestDto.builder()
                .title(productName)
                .description(productDescription)
                .price(productPrice)
                .image(productImageUrl)
                .category(productCategory)
                .build();

        FakeStoreProductDto fakeStoreProductDto =
            restTemplate.postForObject("https://fakestoreapi.com/products", fakeStoreProductRequestDto,
                                       FakeStoreProductDto.class);

        if (fakeStoreProductDto == null) {
            return null;
        }

        return fakeStoreProductDto.toProduct();
    }
}
