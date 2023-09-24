package com.ecommerce.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.demo.entities.Payment;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Integer> {

}
