package com.plantwoo.customer.service;

import com.plantwoo.customer.PlantwooCustomerApplication;
import com.plantwoo.customer.model.Order;
import com.plantwoo.customer.proxy.OrderProxy;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerOrderService {

    @Autowired
    OrderProxy orderProxy;

    public Mono<Order> placeOrder(Order order) {
        return orderProxy.create(order);
    }

    public Flux<Order> getOrders(String orderId) {
        return orderProxy.getOrders(orderId);
    }

    public Mono<Order> getOrderDetail(ObjectId orderId) {
        return null;
    }
}
