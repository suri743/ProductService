package com.personal.productservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FakeStoreProductRequestDto {
    String title;
    double price;
    String description;
    String image;
    String category;
}
