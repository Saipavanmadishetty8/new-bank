package com.example.bank.customer;

import com.example.bank.accounts.AccountType;
import jakarta.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(unique = true)
    private String email;
    private double balance;
    @Enumerated(EnumType.STRING)
    @Column(name = "account_type")
    private AccountType accountType;


    // Constructors
    public Customer() {}

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double balance){
        this.balance=balance;
    }

    public void setAccountType(AccountType accountType){
        this.accountType = accountType;
    }

    public AccountType getAccountType(){
        return accountType;
    }

}
