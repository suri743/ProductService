package com.personal.productservice.service;

import com.personal.productservice.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(String id);
    List<Product> getAllProducts();
    Product createProduct(String productName, String productDescription, Double productPrice,
                          String productImageUrl, String productCategory);
}
