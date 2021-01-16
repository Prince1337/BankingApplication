package com.example.bankingapplication.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class Account {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idAccount;
  private BigDecimal balance;
  @OneToOne(cascade = CascadeType.ALL)
  private Transactions transactions;

  public Account(BigDecimal balance) {
    this.balance = balance;
    transactions = new Transactions();
  }

  public Account() {
  }

  public BigDecimal showBalance() {
    return balance;
  }

  public void add(BigDecimal amount){
    if (isValid(amount)) {
      transactions.addTransaction(balance, amount, TransactionType.DEPOSIT);
      this.balance = balance.add(amount);
    } else {
      this.balance = balance.add(BigDecimal.valueOf(0));
    }
  }

  private boolean isValid(BigDecimal amount) {
    return amount.compareTo(BigDecimal.valueOf(0)) > 0 &&
        amount.compareTo(BigDecimal.valueOf(20001)) < 0;
  }

  public void subtract(BigDecimal amount){
    if (isValid(amount)) {
      transactions.addTransaction(balance, amount, TransactionType.WITHDRAWAL);
      this.balance = balance.subtract(amount);
    } else {
      this.balance = balance.subtract(BigDecimal.valueOf(0));
    }
  }

  public Transactions getTransactions() {
    return transactions;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  @Override
  public String toString() {
    return "Account{" +
            "balance=" + balance +
            '}';
  }
}
