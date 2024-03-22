package com.spharos.ssgdotcom.purchase.dto;

import lombok.Builder;

public class GetPurchaseResponseDto {
    private String userEmail;
    private String productName;
    private int productPrice;
    private String productCategoryName;

    @Builder
    public GetPurchaseResponseDto(String userEmail, String productName, int productPrice, String productCategoryName){
        this.userEmail = userEmail;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCategoryName = productCategoryName;
    }
}
