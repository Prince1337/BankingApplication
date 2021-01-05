package domain.ports;

import domain.entities.Address;
import domain.entities.Customer;
import domain.entities.Transaction;
import domain.entities.TransactionType;

import java.math.BigDecimal;
import java.util.List;

public interface CustomerRegistryPort {
  Customer createCustomer(int id, String name, Address address, BigDecimal initialBalance);
  void transaction(Customer customer, BigDecimal amount, TransactionType transactionType);
  List<Transaction> showPreviousTransactions(Customer customer);
  BigDecimal showBalance(Customer customer);
}
