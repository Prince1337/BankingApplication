package entities;

import java.math.BigDecimal;

public class Customer {

  private final int id;
  private final String name;
  private Address address;
  private Account account;

  public Customer(int id, String name, Address address, BigDecimal initialBalance) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.account = new Account(initialBalance);
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Address getAddress() {
    return address;
  }

  @Override
  public String toString() {
    return "Customer{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", address=" + address +
        '}';
  }

  public Account getAccount() {
    return account;
  }
}
