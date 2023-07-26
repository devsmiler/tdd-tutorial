package com.tdd.payment;

import org.springframework.stereotype.Component;

@Component
public class PaymentGatewayImpl implements PaymentGateway {

    @Override
    public void execute(int totalPrice, String cardNumber) {
        System.out.println("결제 완료");
    }
}
