package com.ecommerce.demo.dto;

import com.ecommerce.demo.model.Customer;

import java.text.DecimalFormat;

public class AccountDto {
    private String id;
    private DecimalFormat balance;
    private AccountCustomerDto customer;
    private TransactionDto transaction;

    public AccountDto(Long id) {
    }
}
