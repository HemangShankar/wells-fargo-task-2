package com.wellsfargo.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable=false)
    private String accountNumber;

    @Column(nullable=false)
    private BigDecimal balance;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Transaction> transactions;

    // Full constructor (excluding id)
    public Account(String accountNumber, BigDecimal balance, Customer customer, List<Transaction> transactions) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customer = customer;
        this.transactions = transactions;
    }

    // ...existing code for default constructor, if any...

    public Long getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
