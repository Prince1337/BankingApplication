package com.example.BankingApplication.domain.ports;

import com.example.BankingApplication.domain.entities.Address;
import com.example.BankingApplication.domain.entities.Customer;
import com.example.BankingApplication.domain.entities.Transaction;
import com.example.BankingApplication.domain.entities.TransactionType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

public interface CustomerRegistryPort {
  Customer createCustomer(int id, String name, Address address, BigDecimal initialBalance);
  void transaction(Customer customer, BigDecimal amount, TransactionType transactionType);
  List<Transaction> showPreviousTransactions(Customer customer);
  BigDecimal showBalance(Customer customer);
}
