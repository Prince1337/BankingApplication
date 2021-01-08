package com.example.bankingapplication.domain.ports;

import com.example.bankingapplication.domain.entities.Customer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


public interface CustomerRepositoryPort {
  void create(Customer customer);
//  void updateCustomer (Customer oldCustomer, Customer newCustomer);
//  Customer findCustomer(int id);
}
