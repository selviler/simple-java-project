package com.ecommerce.demo.service;

import com.ecommerce.demo.exception.CustomerNotFoundException;
import com.ecommerce.demo.model.Customer;
import com.ecommerce.demo.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    protected Customer findCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow(
                () -> new CustomerNotFoundException("Customer not found id" + id)
        );
    }

}
