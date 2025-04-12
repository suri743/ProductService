package com.personal.productservice.dto;

import com.personal.productservice.models.Category;
import com.personal.productservice.models.Product;
import lombok.Data;

@Data
public class FakeStoreProductDto {
    private String id;
    private String title;
    private String description;
    private double price;
    private String image;
    private String category;

    public Product toProduct() {
        return Product.builder()
                .id(Long.parseLong(id))
                .name(title)
                .description(description)
                .price(price)
                .imageUrl(image)
                .category(Category.builder().name(category).build())
                .build();
    }

}
