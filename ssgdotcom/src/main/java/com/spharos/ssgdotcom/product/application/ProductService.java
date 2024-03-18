package com.spharos.ssgdotcom.product.application;

import com.spharos.ssgdotcom.product.dto.ProductDto;
import com.spharos.ssgdotcom.product.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> filter(String category, Integer minPrice, Integer maxPrice, Integer price, Integer stock);
    void createProduct(ProductDto productDto);
}
