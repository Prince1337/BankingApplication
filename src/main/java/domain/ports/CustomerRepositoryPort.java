package domain.ports;

import domain.entities.Customer;

public interface CustomerRepositoryPort {
  void create (Customer customer);
  void updateCustomer (Customer oldCustomer, Customer newCustomer);
  Customer findCustomer(int id);
}
