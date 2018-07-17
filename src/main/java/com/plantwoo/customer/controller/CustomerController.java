package com.plantwoo.customer.controller;

import com.plantwoo.customer.model.Customer;
import com.plantwoo.customer.service.CustomerService;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/customer")
    Mono<Customer> create(@RequestBody Customer customer){
        return customerService.insertUpdate(customer);
    }

    @PutMapping("/customer")
    Mono<Customer> update(@RequestBody Customer customer){
        return customerService.insertUpdate(customer);
    }

    @DeleteMapping("/customer/{customerId}")
    Mono<Void> delete(@PathVariable ObjectId customerId){
        return customerService.delete(customerId);
    }

    @GetMapping("/customer/{customerId}")
    Mono<Customer> getOrder(@PathVariable ObjectId customerId){
        return customerService.getOrder(customerId);
    }

    @GetMapping("/customers")
    Flux<Customer> getCustomers(){
        return customerService.getCustomers();
    }

}
