package entities;

import java.math.BigDecimal;

public class Account {
  private BigDecimal balance;

  public Account(BigDecimal balance) {
    this.balance = balance;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public void add(BigDecimal amount){
    if(isNotValid(amount)){
      amount = BigDecimal.valueOf(0);
    }
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
    this.balance = balance.subtract(amount);
  }

}
