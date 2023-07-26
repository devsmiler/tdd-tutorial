package com.tdd.payment;

import com.tdd.order.Order;

interface PaymentPort {
    public Order getOrder(Long orderId);

    void pay(int totalPrice, String cardNumber);

    void save(Payment payment);
}
