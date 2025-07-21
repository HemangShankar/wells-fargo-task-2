package com.wellsfargo.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private BigDecimal amount;

    @Column(nullable=false)
    private LocalDateTime timestamp;

    @Column(nullable=false)
    private String type;

    @ManyToOne
    @JoinColumn(name="account_id")
    private Account account;

    // Full constructor (excluding id)
    public Transaction(BigDecimal amount, LocalDateTime timestamp, String type, Account account) {
        this.amount = amount;
        this.timestamp = timestamp;
        this.type = type;
        this.account = account;
    }

    // ...existing code for default constructor, if any...

    public Long getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public Account getAccount() {
        return account;
    }
    
    public void setAccount(Account account) {
        this.account = account;
    }
}
