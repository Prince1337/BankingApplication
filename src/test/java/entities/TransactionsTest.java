package entities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

  @Test
  @DisplayName("Add five euro transaction")
  void addFiveEuroTransaction() {
    BigDecimal initialBalance = BigDecimal.valueOf(100);
    BigDecimal amount = BigDecimal.valueOf(5);
    Account testAccount = new Account(initialBalance);

    testAccount.add(amount);

    assertEquals(BigDecimal.valueOf(5), testAccount.getTransactions().getTransactionList().get(0).getAmount());
  }

  @Test
  @DisplayName("Don't add 30000 euro transaction")
  void donTAdd30000EuroTransaction() {
    BigDecimal initialBalance = BigDecimal.valueOf(100);
    BigDecimal amount = BigDecimal.valueOf(30000);
    Account testAccount = new Account(initialBalance);

    testAccount.add(amount);

    assertEquals(0, testAccount.getTransactions().getTransactionList().size());
  }

  @Test
  @DisplayName("Don't add -100 euro deposit transaction")
  void donTAddNegative100EuroDepositTransaction() {
    BigDecimal initialBalance = BigDecimal.valueOf(100);
    BigDecimal amount = BigDecimal.valueOf(-100);
    Account testAccount = new Account(initialBalance);

    testAccount.add(amount);

    assertEquals(0, testAccount.getTransactions().getTransactionList().size());
  }

  @Test
  @DisplayName("Test Transaction Amount for One Dollar Transaction")
  void testTransactionAmountForOneDollarTransaction() {
    BigDecimal initialBalance = BigDecimal.valueOf(100);
    BigDecimal amount = BigDecimal.valueOf(1);
    Account testAccount = new Account(initialBalance);

    testAccount.add(amount);

    assertEquals(amount, testAccount.getTransactions().getTransactionList().get(0).getAmount());
  }

  @Test
  @DisplayName("Test TransactionBalanceForOneDollarTransaction")
  void testTransactionBalanceForOneDollarTransaction() {
    BigDecimal initialBalance = BigDecimal.valueOf(100);
    BigDecimal amount = BigDecimal.valueOf(1);
    Account testAccount = new Account(initialBalance);

    testAccount.add(amount);

    assertEquals(initialBalance, testAccount.getTransactions().getTransactionList().get(0).getBalance());
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

    assertEquals(amount, testAccount.getTransactions().getTransactionList().get(0).getAmount());

  }

  @Test
  @DisplayName("Test transaction balance for one euro withdrawal transaction")
  void testTransactionBalanceForOneEuroWithdrawalTransaction() {
    BigDecimal initialBalance = BigDecimal.valueOf(100);
    BigDecimal amount = BigDecimal.valueOf(1);
    Account testAccount = new Account(initialBalance);

    testAccount.subtract(amount);

    assertEquals(initialBalance, testAccount.getTransactions().getTransactionList().get(0).getBalance());

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