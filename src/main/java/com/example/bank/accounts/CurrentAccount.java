package com.example.bank.accounts;

public class CurrentAccount extends BankAccount {

    public CurrentAccount(int customerId, double balance) {
        super(customerId, balance);
    }

    @Override
    public void deposit(double amount) {
        this.balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        // Assume Current accounts can go into overdraft
        this.balance -= amount;
    }
}
