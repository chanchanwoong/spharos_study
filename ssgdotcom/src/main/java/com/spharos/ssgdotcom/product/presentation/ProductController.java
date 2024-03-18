package com.spharos.ssgdotcom.product.presentation;

import com.spharos.ssgdotcom.product.application.ProductService;
import com.spharos.ssgdotcom.product.model.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@Slf4j
public class ProductController {
    private final ProductService productService;

    @GetMapping("/filter")
    public List<Product> filter(
            @RequestParam String category,
            @RequestParam Integer minPrice,
            @RequestParam Integer maxPrice,
            @RequestParam Integer price,
            @RequestParam Integer stock
    ) {
        log.info("category : {} " , category, "minPrice : {} ", minPrice, "maxPrice : {} ", maxPrice, "price : {} ", price, "stock : {} ", stock);

        return productService.filter(category, minPrice, maxPrice, price, stock);
    }

}
