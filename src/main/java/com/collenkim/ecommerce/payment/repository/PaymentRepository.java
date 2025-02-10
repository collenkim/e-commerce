package com.collenkim.ecommerce.payment.repository;

import com.collenkim.ecommerce.payment.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
