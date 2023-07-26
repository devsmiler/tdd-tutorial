package com.tdd.order;

import com.tdd.product.Product;

interface OrderPort {
    Product getProductById(Long productId);

    void save(Order order);
}
