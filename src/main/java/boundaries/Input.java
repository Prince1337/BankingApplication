package boundaries;

import entities.*;

import java.math.BigDecimal;
import java.util.List;

public interface Input {

  Customer toRegister(int id, String name, String street, int houseNumber, int postalCode, String city);

  void transaction (Customer customer, BigDecimal amount, TransactionType transactionType);

  List<Transaction> showTransactions(Customer customer);

  BigDecimal showBalance (Customer customer);
}
