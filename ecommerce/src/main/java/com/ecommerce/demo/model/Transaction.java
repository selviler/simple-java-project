package com.ecommerce.demo.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Transaction {

    public Transaction()
    {

    }

    public Transaction(BigDecimal amount, Account account)
    {
        this.id = null;
        this.amount = amount;
        this.account = account;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    private BigDecimal amount;


    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;


}
