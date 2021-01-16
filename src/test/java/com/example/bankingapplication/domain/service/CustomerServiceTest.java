package com.example.bankingapplication.domain.service;

import com.example.bankingapplication.domain.entities.Address;
import com.example.bankingapplication.domain.entities.Customer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("PMD.JUnitAssertionsShouldIncludeMessage")
class CustomerServiceTest {
    
    private final static String randomName = "Max Mustermann";
    private final static String randomStreet = "Musterstreet";
    private final static int randomHouseNumber = 42;
    private final static int randomPostalCode = 11111;
    private final static String randomCity = "Mustercity";
    
    @Test
    @DisplayName("Deposit one euro")
    void depositOneEuro() {
        CustomerService customerService = new CustomerService();
        BigDecimal initialBalance = BigDecimal.valueOf(100);
        Customer customer = new Customer(randomName, new Address(randomStreet, randomHouseNumber, randomPostalCode, randomCity), initialBalance);
        BigDecimal amount = BigDecimal.valueOf(1);

        customerService.deposit(customer, amount);

        assertEquals(initialBalance.add(amount), customer.getAccount().showBalance());
    }

    @Test
    @DisplayName("Deposit negative amount")
    void depositNegativeAmount() {
        CustomerService customerService = new CustomerService();
        BigDecimal initialBalance = BigDecimal.valueOf(100);
        Customer customer = new Customer("randomName", new Address(randomStreet, randomHouseNumber, randomPostalCode, randomCity), initialBalance);
        BigDecimal amount = BigDecimal.valueOf(-100);

        customerService.deposit(customer, amount);

        assertEquals(initialBalance, customer.getAccount().showBalance());
    }

    @Test
    @DisplayName("Withdraw one euro")
    void withdrawOneEuro() {
        CustomerService customerService = new CustomerService();
        BigDecimal initialBalance = BigDecimal.valueOf(100);
        Customer customer = new Customer("randomName", new Address(randomStreet, randomHouseNumber, randomPostalCode, randomCity), initialBalance);
        BigDecimal amount = BigDecimal.valueOf(1);

        customerService.withdraw(customer, amount);

        assertEquals(initialBalance.subtract(amount), customer.getAccount().showBalance());
    }

    @Test
    @DisplayName("Withdraw negative amount")
    void withdrawNegativeAmount() {
        CustomerService customerService = new CustomerService();
        BigDecimal initialBalance = BigDecimal.valueOf(100);
        Customer customer = new Customer("randomName", new Address(randomStreet, randomHouseNumber, randomPostalCode, randomCity), initialBalance);
        BigDecimal amount = BigDecimal.valueOf(-100);

        customerService.withdraw(customer, amount);

        assertEquals(initialBalance, customer.getAccount().showBalance());
    }
}