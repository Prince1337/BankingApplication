package com.example.BankingApplication.domain.usecases;

import com.example.BankingApplication.domain.entities.Customer;

import java.math.BigDecimal;

public interface CustomerUseCase {

  void deposit(Customer customer, BigDecimal amount);
  void withdraw(Customer customer, BigDecimal amount);


}
