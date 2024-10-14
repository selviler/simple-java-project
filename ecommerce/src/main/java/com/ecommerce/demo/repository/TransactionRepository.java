package com.ecommerce.demo.repository;

import com.ecommerce.demo.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
