package com.ecommerce.demo.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Optional;
import java.util.Set;

@Entity

public class Account {

    public Account()
    {
    }

    public Account(Customer customer, BigDecimal balance)
    {
        this.customer = customer;
        this.balance = balance;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal balance;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private Set<Transaction> transaction;

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    public Set<Transaction> getTransaction() {
        return this.transaction;
    }

}
