package com.plantwoo.customer.proxy;

import com.plantwoo.customer.model.Order;
import org.bson.types.ObjectId;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@FeignClient(name="gateway-service")
public interface OrderProxy {

    @PostMapping("/order-service/order")
    Mono<Order> create(@RequestBody Order order);

    @GetMapping("/order-service/orders/{customerId}")
    Flux<Order> getOrders(@PathVariable String customerId);
}