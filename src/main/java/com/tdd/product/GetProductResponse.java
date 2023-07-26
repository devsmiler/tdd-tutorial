package com.tdd.product;

import org.springframework.util.Assert;

record GetProductResponse(
        long id,
        String name,
        int price,
        DiscountPolicy discountPolicy) {
    GetProductResponse {
        Assert.notNull(id, "상품 아이디는 필수입니다.");
        Assert.hasText(name, "상품 명은 필수입니다.");
        Assert.isTrue(price > 0, "상품가격은 0보다 커야합니다.");
        Assert.notNull(discountPolicy, "할인 정책은 필수입니다.");
    }
}
