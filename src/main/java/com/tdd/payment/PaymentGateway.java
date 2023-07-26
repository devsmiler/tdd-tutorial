package com.tdd.payment;

interface PaymentGateway {
    void execute(int totalPrice, String cardNumber);
}
