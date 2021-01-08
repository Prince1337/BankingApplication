package com.example.bankingapplication.domain.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idAddress;
  private String street;
  private int houseNumber;
  @Column(name = "postalcode")
  private int postalCode;
  private String city;

  public Address() {
  }

  public Address(String street, int houseNumber, int postalCode, String city) {
    this.street = street;
    this.houseNumber = houseNumber;
    this.postalCode = postalCode;
    this.city = city;
  }



  public String getStreet() {
    return street;
  }

  public int getHouseNumber() {
    return houseNumber;
  }

  public int getPostalCode() {
    return postalCode;
  }

  public String getCity() {
    return city;
  }

  @Override
  public String toString() {
    return "Address: " +
        street + " " +
        houseNumber + " " +
        postalCode + " " +
        city;
  }
}
