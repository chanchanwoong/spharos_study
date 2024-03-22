package com.spharos.ssgdotcom.purchase.service;


import com.spharos.ssgdotcom.purchase.dto.GetPurchaseResponseDto;
import com.spharos.ssgdotcom.purchase.infrastructure.PurchaseRepositoryImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
public class PurchaseServiceImpl implements PurchaseService{

    private final PurchaseRepositoryImpl purchaseRepository;
    @Override
    public List<GetPurchaseResponseDto> getPurchaseByProductCategoryId(Integer categoryId) {
        purchaseRepository.getPurchaseByProductCategoryId(categoryId)
                .forEach(e -> {
                    log.info("e = " + e);
                });

        return purchaseRepository.getPurchaseByProductCategoryId(categoryId).stream()
                .map(m -> GetPurchaseResponseDto.builder()
                        .productCategoryName(m.getProduct().getCategoryName())
                        .productName(m.getProduct().getProductName())
                        .productPrice(m.getProduct().getPrice())
                        .userEmail(m.getMember().getEmail())
                        .build())
                .collect(Collectors.toList());
    }
}