package com.example.bank.Service;

import com.example.bank.accounts.BankAccount;

public class AccountSevices {
    public void performDeposit(BankAccount account, double amount){
        account.deposit(amount);
    }
    public void performWithdrawal(BankAccount account, double amount){
        account.withdraw(amount);
    }

    public void printBalance(BankAccount account){
        System.out.println("Customer ID: " + account.getCustomerId());
        System.out.println("Current Balance: "+ account.getBalance());
    }
}
