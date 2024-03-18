package com.spharos.ssgdotcom.common.specification;

import com.spharos.ssgdotcom.product.model.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecs {

    public static Specification<Product> withCategory(Integer categoryId) {
        if (categoryId == 0) {
            return ( root, query, builder) -> builder.isNotNull(root.get("categoryId")); // return all products if categoryId is 0
        }
        return (root, query, builder) -> builder.equal(root.get("categoryId"), categoryId);
    }

    public static Specification<Product> withPrice(Integer minPrice, Integer maxPrice) {
        if (minPrice == 0 && maxPrice == 0) {
            return (root, query, builder) -> builder.isNotNull(root.get("price")); // return all products if minPrice and maxPrice are 0
        } else if ( minPrice == 0 ) {
            return (root, query, builder) -> builder.lessThanOrEqualTo(root.get("price"), maxPrice);
        } else if ( maxPrice == 0 ) {
            return (root, query, builder) -> builder.greaterThanOrEqualTo(root.get("price"), minPrice);
        }
        return (root, query, builder) -> builder.between(root.get("price"), minPrice, maxPrice);
    }
}