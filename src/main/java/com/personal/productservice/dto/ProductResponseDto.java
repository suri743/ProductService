package com.personal.productservice.dto;


import com.personal.productservice.models.Product;
import lombok.Data;

@Data
public class ProductResponseDto {
    private long id;
    private String name;
    private String description;
    private double price;
    private String imageUrl;
    private String category;

    public static ProductResponseDto from(Product product) {
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setId(product.getId());
        productResponseDto.setName(product.getName());
        productResponseDto.setDescription(product.getDescription());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setImageUrl(product.getImageUrl());
        productResponseDto.setCategory(product.getCategory().getName());
        return productResponseDto;
    }
}
