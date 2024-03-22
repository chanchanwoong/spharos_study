package com.spharos.ssgdotcom.purchase.infrastructure;

import com.spharos.ssgdotcom.purchase.domain.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
