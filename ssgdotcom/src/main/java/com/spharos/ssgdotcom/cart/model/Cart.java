package com.spharos.ssgdotcom.cart.model;

import com.spharos.ssgdotcom.member.domain.Member;
import com.spharos.ssgdotcom.product.model.Product;
import jakarta.persistence.*;

/**
 * Cart 엔티티에는 상품과 고객의 엔티티가 있어야 한다.
 * 실제 필요한 것은 product_id 인데 JPA가 알아서 처리를 해준다.
 * 관계를 설정을 해줘야 한다.
 */
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)      // 나(상품)는 카트에 여러 개 담길 수 있다.
                                            // LAZY는 지연로딩이라고 한다. 서비스단에서 훨 이득을 취하기 때문에 지연로딩을 한다.
    private Product product;
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;
    private Integer quantity;
}
