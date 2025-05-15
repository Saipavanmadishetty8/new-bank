package com.example.bank.accounts;

public class SavingsAccount extends BankAccount {

    public SavingsAccount(int customerId, double balance) {
        super(customerId, balance);
    }

    @Override
    public void deposit(double amount) {
        this.balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
        } else {
            throw new RuntimeException("Insufficient balance in Savings Account");
        }
    }
}

