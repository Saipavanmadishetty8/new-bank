package com.example.bank.Service;

import com.example.bank.accounts.AccountType;
import com.example.bank.accounts.*;
import com.example.bank.accounts.CurrentAccount;
import com.example.bank.customer.Customer;
import com.example.bank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public void depositAmount(long customerID, double amount){
        Customer customer = customerRepository.findById(customerID).orElseThrow(() -> new RuntimeException("Customer Not Found"));
        customer.setBalance(customer.getBalance()+amount);
        customerRepository.save(customer);
    }

    public void withdrawAmount(long customerID, double amount){
        Customer customer = customerRepository.findById(customerID).orElseThrow(() -> new RuntimeException("Customer Not Found"));
        BankAccount account = getAccountHandler(customer);

        if(customer.getBalance()>=amount){
            account.withdraw(amount);
            customer.setBalance(account.getBalance());
            customerRepository.save(customer);
        }
        else{
            throw new RuntimeException("Insufficient Balance");
        }
    }

    public void transferMoney(long fromCustomerId, long toCustomerId, double amount) {
        Customer fromCustomer = customerRepository.findById(fromCustomerId).orElseThrow(() -> new RuntimeException("From Customer not found"));
        Customer toCustomer = customerRepository.findById(toCustomerId).orElseThrow(() -> new RuntimeException("To Customer not found"));

        if (fromCustomer.getBalance() >= amount) {
            fromCustomer.setBalance(fromCustomer.getBalance() - amount);
            toCustomer.setBalance(toCustomer.getBalance() + amount);
            customerRepository.save(fromCustomer);
            customerRepository.save(toCustomer);
        } else {
            throw new RuntimeException("Insufficient balance");
        }
    }
    public BankAccount getAccountHandler(Customer customer) {
        BankAccount account;
        if (customer.getAccountType() == AccountType.SAVINGS) {
            account = new SavingsAccount(customer.getId(),customer.getBalance());
        } else {
            account = new CurrentAccount(customer.getId(),customer.getBalance());
        }

        account.setBalance(customer.getBalance()); // load existing balance

        return account;
    }

}
