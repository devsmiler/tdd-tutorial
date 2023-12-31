package com.tdd.payment;

import org.springframework.util.Assert;

record PaymentRequest(Long orderId, String cardNumber) {
    PaymentRequest {
        Assert.notNull(orderId, "주문번호는 필수입니다.");
        Assert.notNull(cardNumber, "카드 번호는 필수입니다.");
    }
}
