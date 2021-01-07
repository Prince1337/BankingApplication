package com.example.BankingApplication.adapter;

import com.example.BankingApplication.domain.entities.Address;
import com.example.BankingApplication.domain.entities.Customer;
import com.example.BankingApplication.domain.ports.CustomerRegistryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private final CustomerRegistryPort customerRegistryPort;

    public Controller(CustomerRegistryPort customerRegistryPort) {
        this.customerRegistryPort = customerRegistryPort;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping
    public String hi(@RequestParam("name") String name, @RequestParam("street") String street, @RequestParam("houseNumber") int houseNumber,
            @RequestParam("postalCode") int postalCode, @RequestParam("city") String city){
        Address address = new Address(street, houseNumber, postalCode, city);
        Customer customer = customerRegistryPort.createCustomer(0, name, address, BigDecimal.valueOf(0));

        System.out.println(customer);

        return "redirect:/";
    }
}
