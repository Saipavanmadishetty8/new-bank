package com.example.bank.customer;

import com.example.bank.repository.CustomerRepository;
import com.example.bank.Service.CustomerService;
import com.example.bank.customer.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    // Get all customers
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Add a new customer
    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    // Deposit
    @PostMapping("/{customerId}/deposit")
    public ResponseEntity<String> deposit(@PathVariable long customerId, @RequestParam double amount) {
        customerService.depositAmount(customerId, amount);
        return ResponseEntity.ok("Deposited successfully");
    }

    // Withdraw
    @PostMapping("/{customerId}/withdraw")
    public ResponseEntity<String> withdraw(@PathVariable long customerId, @RequestParam double amount) {
        try {
            customerService.withdrawAmount(customerId, amount);
            return ResponseEntity.ok("Withdrawn successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // Transfer Money
    @PostMapping("/{fromCustomerId}/transfer/{toCustomerId}")
    public ResponseEntity<String> transfer(@PathVariable long fromCustomerId, @PathVariable long toCustomerId, @RequestParam double amount) {
        try {
            customerService.transferMoney(fromCustomerId, toCustomerId, amount);
            return ResponseEntity.ok("Transfer successful");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
