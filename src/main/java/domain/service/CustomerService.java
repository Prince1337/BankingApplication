package domain.service;

import domain.entities.*;
import domain.ports.CustomerRegistryPort;
import domain.ports.CustomerRepositoryPort;
import domain.usecases.CustomerUseCase;

import java.math.BigDecimal;
import java.util.List;

public class CustomerService implements CustomerUseCase, CustomerRegistryPort {

  Customer customer;
  private final CustomerRepositoryPort customerRepositoryPort = null;

  @Override
  public Customer createCustomer(int id, String name, Address address, BigDecimal initialBalance) {
    this.customer = new Customer(id, name, address, initialBalance);
    return customer;
  }

  public void saveCustomer(){
    customerRepositoryPort.create(customer);
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
