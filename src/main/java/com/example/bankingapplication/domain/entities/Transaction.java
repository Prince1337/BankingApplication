package com.example.bankingapplication.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class Transaction {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idTransaction;
  private final BigDecimal transactionBalance;
  private final BigDecimal transactionAmount;
  private BigDecimal credit;
  @Embedded
  private final TransactionType type;

  public Transaction(BigDecimal transactionBalance, BigDecimal transactionAmount, TransactionType type) {
    this.transactionBalance = transactionBalance;
    this.transactionAmount = transactionAmount;
    this.type = type;
    this.credit = BigDecimal.valueOf(0);

    if (type == TransactionType.DEPOSIT)
      credit = transactionBalance.add(transactionAmount);
    if (type == TransactionType.WITHDRAWAL)
      credit = transactionBalance.subtract(transactionAmount);
  }

  public BigDecimal getTransactionAmount() {
    return transactionAmount;
  }

  public BigDecimal getTransactionBalance() {
    return transactionBalance;
  }

  public BigDecimal getCredit() {
    return credit;
  }

  public TransactionType getType() {
    return type;
  }
}
