package com.example.bankingapplication.domain.entities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("PMD.JUnitAssertionsShouldIncludeMessage")
class AccountTest {
    @Test
    @DisplayName("Create account")
    void createAccount() {
        BigDecimal initialBalance = BigDecimal.valueOf(100);
        Account testAccount = new Account(initialBalance);
        assertNotNull(testAccount, "Account wurde erstellt");
    }

    @Test
    @DisplayName("add one euro")
    void addOneEuro() {
        BigDecimal initialBalance = BigDecimal.valueOf(100);
        BigDecimal amount = BigDecimal.valueOf(1);
        Account testAccount = new Account(initialBalance);

        testAccount.add(amount);

        assertEquals(initialBalance.add(amount), testAccount.showBalance());
    }

    @Test
    @DisplayName("add Zero euros")
    void addZeroEuros() {
        BigDecimal initialBalance = BigDecimal.valueOf(100);
        BigDecimal amount = BigDecimal.valueOf(0);
        Account testAccount = new Account(initialBalance);

        testAccount.add(amount);

        assertEquals(initialBalance.add(amount), testAccount.showBalance());
    }

    @Test
    @DisplayName("add negative amount")
    void addNegativeAmount() {
        BigDecimal initialBalance = BigDecimal.valueOf(100);
        BigDecimal amount = BigDecimal.valueOf(-100);
        Account testAccount = new Account(initialBalance);

        testAccount.add(amount);

        assertEquals(initialBalance, testAccount.showBalance());
    }

    @Test
    @DisplayName("add more than highest amount")
    void addMoreThanHighestAmount() {
        BigDecimal initialBalance = BigDecimal.valueOf(100);
        BigDecimal amount = BigDecimal.valueOf(20001);
        Account testAccount = new Account(initialBalance);

        testAccount.add(amount);

        assertEquals(initialBalance, testAccount.showBalance());
    }

    @Test
    @DisplayName("subtract one euro")
    void subtractOneEuro() {
        BigDecimal initialBalance = BigDecimal.valueOf(100);
        BigDecimal amount = BigDecimal.valueOf(1);
        Account testAccount = new Account(initialBalance);

        testAccount.subtract(amount);

        assertEquals(initialBalance.subtract(amount), testAccount.showBalance());

    }

    @Test
    @DisplayName("subtract zero euros")
    void subtractZeroEuros() {
        BigDecimal initialBalance = BigDecimal.valueOf(100);
        BigDecimal amount = BigDecimal.valueOf(0);
        Account testAccount = new Account(initialBalance);

        testAccount.subtract(amount);

        assertEquals(initialBalance.subtract(amount), testAccount.showBalance());
    }

    @Test
    @DisplayName("subtract negative amount")
    void subtractNegativeAmount() {
        BigDecimal initialBalance = BigDecimal.valueOf(100);
        BigDecimal amount = BigDecimal.valueOf(-100);
        Account testAccount = new Account(initialBalance);

        testAccount.subtract(amount);

        assertEquals(initialBalance, testAccount.showBalance());
    }

    @Test
    @DisplayName("subtract more than highest amount")
    void subtractMoreThanHighestAmount() {
        BigDecimal initialBalance = BigDecimal.valueOf(100);
        BigDecimal amount = BigDecimal.valueOf(20001);
        Account testAccount = new Account(initialBalance);

        testAccount.subtract(amount);

        assertEquals(initialBalance, testAccount.showBalance());
    }
}