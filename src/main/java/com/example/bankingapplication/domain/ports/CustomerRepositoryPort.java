package com.example.bankingapplication.domain.ports;

import com.example.bankingapplication.domain.entities.Customer;

import java.util.Optional;


public interface CustomerRepositoryPort {
  void create(Customer customer);
  void delete (Customer customer);
  void updateCustomer (Customer oldCustomer, Customer newCustomer);
  Optional<Customer> findCustomer(int id);
}
