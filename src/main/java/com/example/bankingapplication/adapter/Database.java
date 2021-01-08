package com.example.bankingapplication.adapter;

import com.example.bankingapplication.database.CustomerRepository;
import com.example.bankingapplication.domain.entities.Customer;
import com.example.bankingapplication.domain.ports.CustomerRepositoryPort;
import org.springframework.stereotype.Component;

@Component
public class Database implements CustomerRepositoryPort{
  private final CustomerRepository customerRepository;

  public Database(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @Override
  public void create(Customer customer) {
    System.out.println(customer);
    customerRepository.save(customer);
  }

//

}
