package com.example.bankingapplication.domain.service;

import com.example.bankingapplication.domain.entities.Address;
import com.example.bankingapplication.domain.entities.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class CustomerServiceTest {
    @Test
    @DisplayName("Deposit one euro")
    void depositOneEuro() {
        CustomerService customerService = new CustomerService();
        BigDecimal initialBalance = BigDecimal.valueOf(100);
        Customer customer = new Customer("Max Mustermann", new Address("Musterstreet", 42, 11111, "Mustercity"), initialBalance);
        BigDecimal amount = BigDecimal.valueOf(1);

        customerService.deposit(customer, amount);

        Assertions.assertEquals(initialBalance.add(amount), customer.getAccount().showBalance());
    }

    @Test
    @DisplayName("Deposit negative amount")
    void depositNegativeAmount() {
        CustomerService customerService = new CustomerService();
        BigDecimal initialBalance = BigDecimal.valueOf(100);
        Customer customer = new Customer("Max Mustermann", new Address("Musterstreet", 42, 11111, "Mustercity"), initialBalance);
        BigDecimal amount = BigDecimal.valueOf(-100);

        customerService.deposit(customer, amount);

        Assertions.assertEquals(initialBalance, customer.getAccount().showBalance());
    }

    @Test
    @DisplayName("Withdraw one euro")
    void withdrawOneEuro() {
        CustomerService customerService = new CustomerService();
        BigDecimal initialBalance = BigDecimal.valueOf(100);
        Customer customer = new Customer("Max Mustermann", new Address("Musterstreet", 42, 11111, "Mustercity"), initialBalance);
        BigDecimal amount = BigDecimal.valueOf(1);

        customerService.withdraw(customer, amount);

        Assertions.assertEquals(initialBalance.subtract(amount), customer.getAccount().showBalance());
    }

    @Test
    @DisplayName("Withdraw negative amount")
    void withdrawNegativeAmount() {
        CustomerService customerService = new CustomerService();
        BigDecimal initialBalance = BigDecimal.valueOf(100);
        Customer customer = new Customer("Max Mustermann", new Address("Musterstreet", 42, 11111, "Mustercity"), initialBalance);
        BigDecimal amount = BigDecimal.valueOf(-100);

        customerService.withdraw(customer, amount);

        Assertions.assertEquals(initialBalance, customer.getAccount().showBalance());
    }
}