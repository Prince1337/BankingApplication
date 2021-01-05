package entities;

import java.math.BigDecimal;

public class Transaction {

  private final BigDecimal balance;
  private final BigDecimal amount;
  private BigDecimal credit;
  private final TransactionType type;

  public Transaction(BigDecimal balance, BigDecimal amount, TransactionType type) {
    this.balance = balance;
    this.amount = amount;
    this.type = type;
    this.credit = BigDecimal.valueOf(0);

    if (type == TransactionType.DEPOSIT)
      credit = balance.add(amount);
    if (type == TransactionType.WITHDRAWAL)
      credit = balance.subtract(amount);
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public BigDecimal getCredit() {
    return credit;
  }

  public TransactionType getType() {
    return type;
  }
}
