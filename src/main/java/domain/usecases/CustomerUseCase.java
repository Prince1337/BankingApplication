package domain.usecases;

import domain.entities.Customer;

import java.math.BigDecimal;

public interface CustomerUseCase {

  void deposit(Customer customer, BigDecimal amount);
  void withdraw(Customer customer, BigDecimal amount);


}
