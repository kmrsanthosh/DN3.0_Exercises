package com.dependencyinjectionexample;

public class CustomerService {
    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public String getCustomer(int id) {
        return repository.findCustomerById(id);
    }
}
