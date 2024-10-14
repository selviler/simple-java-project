package com.ecommerce.demo.service;

import com.ecommerce.demo.model.Account;
import com.ecommerce.demo.model.Transaction;
import com.ecommerce.demo.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    protected Transaction initiateMoney(final Account account, BigDecimal amount)
    {
        return transactionRepository.save(
                new Transaction(amount, account)
        );
    }

    public void createTransaction()
    {

    }
}
