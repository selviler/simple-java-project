package com.example.spring_start.controller;

import com.example.spring_start.model.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest/api")
public class RestCustomerController {

    @GetMapping(path = "/customer")
    public List<Customer> getAllCustomer(){
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1,"name","name@example.com"));
        customers.add(new Customer(2,"name1","nam1@example.com"));
        customers.add(new Customer(3,"name2","nam2@example.com"));
        return customers;
    }
}
