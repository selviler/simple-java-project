package com.ecommerce.demo.dto;

import com.ecommerce.demo.model.TransactionType;

import java.math.BigDecimal;

public class TransactionDto {
    private Long id;
    private TransactionType type;
    private BigDecimal amount;
}
