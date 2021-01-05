package com.example.BankingApplication.domain.ports;


import com.example.BankingApplication.domain.entities.Customer;

public interface CustomerRepositoryPort {
  void create (Customer customer);
  void updateCustomer (Customer oldCustomer, Customer newCustomer);
  Customer findCustomer(int id);
}
