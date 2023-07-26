package com.tdd.order;

import org.springframework.util.Assert;

record CreateOrderRequest(Long productId, int quantity) {
    public CreateOrderRequest {
        Assert.notNull(productId, "상품아이디는 필수입니다.");
        Assert.isTrue(quantity > 0, "주문 갯수는 0보다 커야합니다.");
    }
}
