package com.plantwoo.customer.service;

import com.plantwoo.customer.model.Customer;
import com.plantwoo.customer.repository.ReactiveCustomerRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerService {

    @Autowired
    ReactiveCustomerRepository customerRepository;

    public Mono<Customer> insertUpdate(Customer customer) {
       return customerRepository.save(customer);
    }

    public Mono<Void> delete(ObjectId customerId) {
        return customerRepository.deleteById(customerId);
    }

    public Mono<Customer> getOrder(ObjectId customerId) {
        return customerRepository.findById(customerId);
    }

    public Flux<Customer> getCustomers() {
        return customerRepository.findAll();
    }
}
