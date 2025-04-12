package com.personal.productservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    private long id;
    private String name;
    private String description;
    private double price;
    private String imageUrl;
    private Category category;
}
