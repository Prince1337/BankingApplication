package entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Transactions {

  private final List<Transaction> transactionList;

  public Transactions() {
    this.transactionList = new ArrayList<>();
  }

  public void addTransaction(BigDecimal balance, BigDecimal amount, TransactionType transactionType) {
    transactionList.add(new Transaction(balance, amount, transactionType));
  }

  public List<Transaction> getTransactionList() {
    transactionList.removeIf(transaction -> transaction.getAmount().equals(BigDecimal.valueOf(0)));
    return transactionList;
  }

}
