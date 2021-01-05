import entities.Address;
import entities.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class InteractorTest {

  @Test
  @DisplayName("Deposit one euro")
  void depositOneEuro() {
    Interactor interactor = new Interactor();
    BigDecimal initialBalance = BigDecimal.valueOf(100);
    Customer customer = new Customer(0, "Max Mustermann", new Address("Musterstreet", 42, 11111, "Mustercity"), initialBalance);
    BigDecimal amount = BigDecimal.valueOf(1);

    interactor.deposit(customer, amount);

    Assertions.assertEquals(initialBalance.add(amount), customer.getAccount().showBalance());
  }

  @Test
  @DisplayName("Deposit negative amount")
  void depositNegativeAmount() {
    Interactor interactor = new Interactor();
    BigDecimal initialBalance = BigDecimal.valueOf(100);
    Customer customer = new Customer(0, "Max Mustermann", new Address("Musterstreet", 42, 11111, "Mustercity"), initialBalance);
    BigDecimal amount = BigDecimal.valueOf(-100);

    interactor.deposit(customer, amount);

    Assertions.assertEquals(initialBalance, customer.getAccount().showBalance());
  }

  @Test
  @DisplayName("Withdraw one euro")
  void withdrawOneEuro() {
    Interactor interactor = new Interactor();
    BigDecimal initialBalance = BigDecimal.valueOf(100);
    Customer customer = new Customer(0, "Max Mustermann", new Address("Musterstreet", 42, 11111, "Mustercity"), initialBalance);
    BigDecimal amount = BigDecimal.valueOf(1);

    interactor.withdraw(customer, amount);

    Assertions.assertEquals(initialBalance.subtract(amount), customer.getAccount().showBalance());
  }

  @Test
  @DisplayName("Withdraw negative amount")
  void withdrawNegativeAmount() {
    Interactor interactor = new Interactor();
    BigDecimal initialBalance = BigDecimal.valueOf(100);
    Customer customer = new Customer(0, "Max Mustermann", new Address("Musterstreet", 42, 11111, "Mustercity"), initialBalance);
    BigDecimal amount = BigDecimal.valueOf(-100);

    interactor.withdraw(customer, amount);

    Assertions.assertEquals(initialBalance, customer.getAccount().showBalance());
  }



}