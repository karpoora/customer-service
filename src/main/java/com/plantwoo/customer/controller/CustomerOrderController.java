package com.plantwoo.customer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.plantwoo.customer.model.Order;
import com.plantwoo.customer.service.CustomerOrderService;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CustomerOrderController {
    @Autowired
    CustomerOrderService customerOrderService;

    public static final Logger LOGGER = LoggerFactory.getLogger(CustomerOrderController.class);
    @GetMapping("/test")
    public String getUserTest(){
        LOGGER.info("in customerOrderService Test API");
        return "success";
    }

    @PostMapping("/placeOrder")
    Mono<Order> placeOrder(@RequestBody Order order){
       return customerOrderService.placeOrder(order);
    }

    @GetMapping("/orders/{customerId}")
    Flux<Order> getOrders(@PathVariable String customerId){
        LOGGER.info("Get Order List for Customer Id: {}", customerId);
        return customerOrderService.getOrders(customerId);
    }

    @GetMapping("/order/{orderId}")
    Mono<Order> getOrders(@PathVariable ObjectId orderId){
        return customerOrderService.getOrderDetail(orderId);
    }
}
