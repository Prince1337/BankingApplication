package com.example.bankingapplication.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private final String name;
  @OneToOne(cascade = CascadeType.ALL)
  private Address address;
  @OneToOne(cascade = CascadeType.ALL)
  private Account account;

  public Customer(String name, Address address, BigDecimal initialBalance) {
    this.name = name;
    this.address = address;
    this.account = new Account(initialBalance);
	System.out.println(account);
  }

  public long getId() {
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
            ", account=" + account +
            '}';
  }

  public Account getAccount() {
    return account;
  }
}
