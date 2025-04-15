package com.personal.productservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateFakeStoreProductDto {
    private String name;
    private String description;
    private String imageUrl;
    private double price;
    private String category;
}
