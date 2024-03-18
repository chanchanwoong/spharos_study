package com.spharos.ssgdotcom.product.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

    private String productName;
    private Integer price;
    private Integer stock;
    private Integer category;

}