package com.sunil.smartticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunil.smartticketbooking.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}