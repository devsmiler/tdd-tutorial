package com.tdd.payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
