package com.example.bankingapplication.adapter;

import com.example.bankingapplication.domain.entities.Address;
import com.example.bankingapplication.domain.entities.Customer;
import com.example.bankingapplication.domain.ports.CustomerRegistryPort;
import com.example.bankingapplication.domain.ports.CustomerRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private final CustomerRegistryPort customerRegistryPort;
    @Autowired
    private final CustomerRepositoryPort customerRepositoryPort;

    public Controller(CustomerRegistryPort customerRegistryPort, CustomerRepositoryPort customerRepositoryPort) {
        this.customerRegistryPort = customerRegistryPort;
        this.customerRepositoryPort = customerRepositoryPort;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping
    public String hi(@RequestParam("name") String name, @RequestParam("street") String street, @RequestParam("houseNumber") int houseNumber,
            @RequestParam("postalCode") int postalCode, @RequestParam("city") String city){
        Address address = new Address(street, houseNumber, postalCode, city);
        System.out.println(address);
        Customer customer = customerRegistryPort.createCustomer(0, name, address, BigDecimal.valueOf(0));
        customerRepositoryPort.create(customer);

        return "redirect:/";
    }
}
