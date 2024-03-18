package com.spharos.ssgdotcom.product.application;

import com.spharos.ssgdotcom.common.specification.ProductSpecs;
import com.spharos.ssgdotcom.product.dto.ProductDto;
import com.spharos.ssgdotcom.product.infrastructure.ProductRepository;
import com.spharos.ssgdotcom.product.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    @Override
    public List<Product> filter(String category, Integer minPrice, Integer maxPrice, Integer price, Integer stock) {
        Specification<Product> spec = ProductSpecs.withPrice(minPrice, maxPrice)
                .or(ProductSpecs.withCategory(Integer.parseInt(category)));

        return productRepository.findAll(spec);
    }

    @Override
    public void createProduct(ProductDto productDto) {
        Product product = Product.builder()
                .productName(productDto.getProductName())
                .price(productDto.getPrice())
                .stock(productDto.getStock())
                .categoryId(productDto.getCategory())
                .build();
        productRepository.save(product);
    }
}
