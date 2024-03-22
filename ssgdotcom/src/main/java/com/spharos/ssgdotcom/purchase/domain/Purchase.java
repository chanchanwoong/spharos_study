package com.spharos.ssgdotcom.purchase.domain;

import com.spharos.ssgdotcom.member.domain.Member;
import com.spharos.ssgdotcom.product.model.Product;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @Builder
    public Purchase(Member member, Product product) {
        this.member = member;
        this.product = product;
    }

}
