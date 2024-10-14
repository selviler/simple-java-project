package com.ecommerce.demo.dto;

import com.ecommerce.demo.model.Transaction;

import java.math.BigDecimal;

public class CustomerAccountDto {
    private String id;
    private BigDecimal balance;
    private TransactionDto transaction;
}
