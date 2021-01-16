package com.example.bankingapplication.adapter;

import com.example.bankingapplication.domain.entities.Address;
import com.example.bankingapplication.domain.entities.Customer;
import com.example.bankingapplication.domain.ports.CustomerRegistryPort;
import com.example.bankingapplication.domain.ports.CustomerRepositoryPort;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.Transient;
import java.math.BigDecimal;

@org.springframework.stereotype.Controller
@Data
public class Controller {

    @Transient
    private final CustomerRegistryPort customerRegistryPort;
    @Transient
    private final CustomerRepositoryPort customerRepositoryPort;

    public Controller(CustomerRegistryPort customerRegistryPort, CustomerRepositoryPort customerRepositoryPort) {
        this.customerRegistryPort = customerRegistryPort;
        this.customerRepositoryPort = customerRepositoryPort;
    }

    @GetMapping("/")
    public String registration() {
        return "index";
    }

    @PostMapping
    public String registrationData(@RequestParam("name") String name, @RequestParam("street") String street, @RequestParam("houseNumber") int houseNumber,
            @RequestParam("postalCode") int postalCode, @RequestParam("city") String city){
        Address address = new Address(street, houseNumber, postalCode, city);
        Customer customer = customerRegistryPort.createCustomer(0, name, address, BigDecimal.valueOf(0));
        customerRepositoryPort.create(customer);

        return "redirect:/";
    }
}
