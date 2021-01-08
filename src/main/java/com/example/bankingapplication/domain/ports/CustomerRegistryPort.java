package com.example.bankingapplication.domain.ports;

import com.example.bankingapplication.domain.entities.Address;
import com.example.bankingapplication.domain.entities.Customer;
import com.example.bankingapplication.domain.entities.Transaction;
import com.example.bankingapplication.domain.entities.TransactionType;

import java.math.BigDecimal;
import java.util.List;

public interface CustomerRegistryPort {
  Customer createCustomer(int id, String name, Address address, BigDecimal initialBalance);
  void transaction(Customer customer, BigDecimal amount, TransactionType transactionType);
  List<Transaction> showPreviousTransactions(Customer customer);
  BigDecimal showBalance(Customer customer);
}
