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


    // Constructors parameterless
    public Customer() {}

    // Constructor with parameters name, email
    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters for id
    public Long getId() {
        return id;
    }

    // Getters and Setters for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getters and Setters for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getters and Setters for balance
    public double getBalance(){
        return balance;
    }

    public void setBalance(double balance){
        this.balance=balance;
    }

    // Getters and Setters for account type
    public void setAccountType(AccountType accountType){
        this.accountType = accountType;
    }

    public AccountType getAccountType(){
        return accountType;
    }

}
