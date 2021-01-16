package com.example.bankingapplication.domain.entities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("PMD.JUnitAssertionsShouldIncludeMessage")
class TransactionsTest {

    @Test
    @DisplayName("Test that Transaction was created")
    void testTransactionWasCreated() {
        BigDecimal initialBalance = BigDecimal.valueOf(100);
        BigDecimal amount = BigDecimal.valueOf(1);
        Account testAccount = new Account(initialBalance);

        testAccount.add(amount);

        assertEquals(1, testAccount.getTransactions().getTransactionList().size());
    }

    @ParameterizedTest
    @DisplayName("parameterized")
    @ValueSource(ints = {5, 20000})
    void addValidAmount(int amount) {
        BigDecimal initialBalance = BigDecimal.valueOf(100);
        Account testAccount = new Account(initialBalance);

        testAccount.add(BigDecimal.valueOf(amount));

        assertEquals(BigDecimal.valueOf(amount), testAccount.getTransactions().getTransactionList().get(0).getTransactionAmount());
    }

    @ParameterizedTest
    @ValueSource(ints = {30000, -100, 0})
    void dontAddInvalidAmount(int amount){
        BigDecimal initialBalance = BigDecimal.valueOf(100);
        Account testAccount = new Account(initialBalance);

        testAccount.add(BigDecimal.valueOf(amount));

        assertEquals(0, testAccount.getTransactions().getTransactionList().size());
    }

    @Test
    @DisplayName("add 20000 euro transaction")
    void add20000EuroTransaction() {
        BigDecimal initialBalance = BigDecimal.valueOf(100);
        BigDecimal amount = BigDecimal.valueOf(20000);
        Account testAccount = new Account(initialBalance);

        testAccount.add(amount);

        assertEquals(1, testAccount.getTransactions().getTransactionList().size());
    }

    @Test
    @DisplayName("Test Transaction Amount for One Dollar Transaction")
    void testTransactionAmountForOneDollarTransaction() {
        BigDecimal initialBalance = BigDecimal.valueOf(100);
        BigDecimal amount = BigDecimal.valueOf(1);
        Account testAccount = new Account(initialBalance);

        testAccount.add(amount);

        assertEquals(amount, testAccount.getTransactions().getTransactionList().get(0).getTransactionAmount());
    }

    @Test
    @DisplayName("Test TransactionBalanceForOneDollarTransaction")
    void testTransactionBalanceForOneDollarTransaction() {
        BigDecimal initialBalance = BigDecimal.valueOf(100);
        BigDecimal amount = BigDecimal.valueOf(1);
        Account testAccount = new Account(initialBalance);

        testAccount.add(amount);

        assertEquals(initialBalance, testAccount.getTransactions().getTransactionList().get(0).getTransactionBalance());
    }

    @Test
    @DisplayName("Test Transaction Credit for one euro transaction")
    void testTransactionCreditForOneEuroTransaction() {
        BigDecimal initialBalance = BigDecimal.valueOf(100);
        BigDecimal amount = BigDecimal.valueOf(1);
        Account testAccount = new Account(initialBalance);

        testAccount.add(amount);

        assertEquals(initialBalance.add(amount), testAccount.getTransactions().getTransactionList().get(0).getCredit());
    }

    @Test
    @DisplayName("Test transaction type for one euro transaction")
    void testTransactionTypeForOneEuroTransaction() {
        BigDecimal initialBalance = BigDecimal.valueOf(100);
        BigDecimal amount = BigDecimal.valueOf(1);
        Account testAccount = new Account(initialBalance);

        testAccount.add(amount);

        assertEquals(TransactionType.DEPOSIT, testAccount.getTransactions().getTransactionList().get(0).getType());
    }

    @Test
    @DisplayName("Test Transaction amount for one euro withdrawal transaction")
    void testTransactionAmountForOneEuroWithdrawalTransaction() {
        BigDecimal initialBalance = BigDecimal.valueOf(100);
        BigDecimal amount = BigDecimal.valueOf(1);
        Account testAccount = new Account(initialBalance);

        testAccount.subtract(amount);

        assertEquals(amount, testAccount.getTransactions().getTransactionList().get(0).getTransactionAmount());

    }

    @Test
    @DisplayName("Test transaction balance for one euro withdrawal transaction")
    void testTransactionBalanceForOneEuroWithdrawalTransaction() {
        BigDecimal initialBalance = BigDecimal.valueOf(100);
        BigDecimal amount = BigDecimal.valueOf(1);
        Account testAccount = new Account(initialBalance);

        testAccount.subtract(amount);

        assertEquals(initialBalance, testAccount.getTransactions().getTransactionList().get(0).getTransactionBalance());

    }

    @Test
    @DisplayName("Test transaction credit for one euro withdrawal transaction")
    void testTransactionCreditForOneEuroWithdrawalTransaction() {
        BigDecimal initialBalance = BigDecimal.valueOf(100);
        BigDecimal amount = BigDecimal.valueOf(1);
        Account testAccount = new Account(initialBalance);

        testAccount.subtract(amount);

        assertEquals(initialBalance.subtract(amount), testAccount.getTransactions().getTransactionList().get(0).getCredit());

    }

    @Test
    @DisplayName("Test transaction type for one euro withdrawal transaction")
    void testTransactionTypeForOneEuroWithdrawalTransaction() {
        BigDecimal initialBalance = BigDecimal.valueOf(100);
        BigDecimal amount = BigDecimal.valueOf(1);
        Account testAccount = new Account(initialBalance);

        testAccount.subtract(amount);

        assertEquals(TransactionType.WITHDRAWAL, testAccount.getTransactions().getTransactionList().get(0).getType());

    }
}