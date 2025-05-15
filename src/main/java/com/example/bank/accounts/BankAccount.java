package com.example.bank.accounts;

public abstract class BankAccount {
    protected int customerId;
    protected double balance;

    public BankAccount(int customerId, double balance) {
        this.customerId = customerId;
        this.balance = balance;
    }

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);

    public double getBalance() {
        return balance;
    }

    public int getCustomerId() {
        return customerId;
    }
}

