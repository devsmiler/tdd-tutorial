package com.tdd.product;

import org.springframework.stereotype.Component;


interface ProductPort {
    public void save(Product product);

    Product getProduct(long productId);
}
