package com.spharos.ssgdotcom.product.presentation;

import com.spharos.ssgdotcom.product.application.ProductService;
import com.spharos.ssgdotcom.product.dto.ProductDto;
import com.spharos.ssgdotcom.product.model.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
@Slf4j
public class ProductController {
    private final ProductService productService;

    @PostMapping("/create-product")
    public void createProduct(@RequestBody ProductDto product) {
        log.info("product: {}", product);
        productService.createProduct(product);
    }

    @GetMapping("/find-product")
    public List<Product> filter(
            @RequestParam(value = "category", required = false) String category,
            @RequestParam(value = "minPrice", required = false) Integer minPrice,
            @RequestParam(value = "maxPrice", required = false) Integer maxPrice,
            @RequestParam(value = "price", required = false) Integer price,
            @RequestParam(value = "stock", required = false) Integer stock
    ) {
        log.info("category : {} " , category, "minPrice : {} ", minPrice, "maxPrice : {} ", maxPrice, "price : {} ", price, "stock : {} ", stock);

        return productService.filter(category, minPrice, maxPrice, price, stock);
    }

}
