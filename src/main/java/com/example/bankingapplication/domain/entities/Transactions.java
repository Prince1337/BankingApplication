package com.example.bankingapplication.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Transactions {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idTransactions;
  @OneToMany(targetEntity=Customer.class, mappedBy="account", fetch=FetchType.EAGER)
  private final List<Transaction> transactionList;

  public Transactions() {
    this.transactionList = new ArrayList<>();
  }

  public void addTransaction(BigDecimal balance, BigDecimal amount, TransactionType transactionType) {
    transactionList.add(new Transaction(balance, amount, transactionType));
  }

  public List<Transaction> getTransactionList() {
    transactionList.removeIf(transaction -> transaction.getTransactionAmount().equals(BigDecimal.valueOf(0)));
    return transactionList;
  }

}
