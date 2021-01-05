package entities;

import java.math.BigDecimal;

public class Account {
  private BigDecimal balance;
  private Transactions transactions;

  public Account(BigDecimal balance) {
    this.balance = balance;
    transactions = new Transactions();
  }

  public BigDecimal showBalance() {
    return balance;
  }

  public void add(BigDecimal amount){
    if(isNotValid(amount)){
      amount = BigDecimal.valueOf(0);
    }
    else
      transactions.addTransaction(balance, amount, TransactionType.DEPOSIT);

    this.balance = balance.add(amount);
  }

  private boolean isNotValid(BigDecimal amount) {
    return amount.compareTo(BigDecimal.valueOf(0)) < 0 ||
        amount.compareTo(BigDecimal.valueOf(20000)) > 0;
  }

  public void subtract(BigDecimal amount){
    if(isNotValid(amount)){
      amount = BigDecimal.valueOf(0);
    }
    else
      transactions.addTransaction(balance, amount, TransactionType.WITHDRAWAL);

    this.balance = balance.subtract(amount);
  }

  public Transactions getTransactions() {
    return transactions;
  }
}
