package com.example.bank.accounts;

public abstract class BankAccount {
    protected long customerId;
    protected double balance;

    public BankAccount(long customerId, double balance) {
        this.customerId = customerId;
        this.balance = balance;
    }

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public long getCustomerId() {
        return customerId;
    }
}

