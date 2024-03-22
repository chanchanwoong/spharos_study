package com.spharos.ssgdotcom.purchase.infrastructure;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.spharos.ssgdotcom.purchase.domain.Purchase;
import com.spharos.ssgdotcom.purchase.domain.QPurchase;
import com.spharos.ssgdotcom.purchase.service.PurchaseService;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PurchaseRepositoryImpl extends QuerydslRepositorySupport {

    private final PurchaseService purchaseService;
    private final JPAQueryFactory jpaQueryFactory;

    public PurchaseRepositoryImpl(PurchaseService purchaseService, JPAQueryFactory jpaQueryFactory) {
        super(Purchase.class);
        this.purchaseService = purchaseService;
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public List<Purchase> getPurchaseByProductCategoryId(Integer categoryId) {

        QPurchase purchase = QPurchase.purchase;

        return jpaQueryFactory.select(purchase)
                .from(purchase)
                .where(purchase.product.categoryId.eq(categoryId))
                .fetch();
    }


}