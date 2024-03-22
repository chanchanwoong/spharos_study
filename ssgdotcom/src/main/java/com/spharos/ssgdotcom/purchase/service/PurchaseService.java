package com.spharos.ssgdotcom.purchase.service;

import com.spharos.ssgdotcom.purchase.dto.GetPurchaseResponseDto;

import java.util.List;

public interface PurchaseService {
    List<GetPurchaseResponseDto> getPurchaseByProductCategoryId(Integer categoryId);
}
