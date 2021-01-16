package com.example.bankingapplication.domain.service;


import com.example.bankingapplication.domain.entities.*;
import com.example.bankingapplication.domain.ports.CustomerRegistryPort;
import com.example.bankingapplication.domain.ports.CustomerRepositoryPort;
import com.example.bankingapplication.domain.usecases.CustomerUseCase;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@Data
public class CustomerService implements CustomerUseCase, CustomerRegistryPort {

  @Autowired
  private final CustomerRepositoryPort customerRepositoryPort;

  public CustomerService() {
    customerRepositoryPort = null;
  }

  public CustomerService(CustomerRepositoryPort customerRepositoryPort) {
    this.customerRepositoryPort = customerRepositoryPort;
  }

  @Override
  public Customer createCustomer(int id, String name, Address address, BigDecimal initialBalance) {
    Customer customer = new Customer(name, address, initialBalance);
      assert customerRepositoryPort != null;
      customerRepositoryPort.create(customer);
    return customer;
  }



  @Override
  public BigDecimal showBalance(Customer customer) {
    return customer.getAccount().showBalance();
  }

  @Override
  public void transaction(Customer customer, BigDecimal amount, TransactionType transactionType) {
    if(transactionType == TransactionType.DEPOSIT){
      deposit(customer, amount);
    }
    if(transactionType == TransactionType.WITHDRAWAL){
      withdraw(customer, amount);
    }
  }

  @Override
  public void deposit(Customer customer, BigDecimal amount) {
    Account account = customer.getAccount();
    account.add(amount);
  }

  @Override
  public void withdraw(Customer customer, BigDecimal amount) {
    Account account = customer.getAccount();
    account.subtract(amount);
  }

  @Override
  public List<Transaction> showPreviousTransactions(Customer customer) {
    return customer.getAccount().getTransactions().getTransactionList();
  }

}
