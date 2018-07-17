package com.plantwoo.customer.repository;

import com.plantwoo.customer.model.Customer;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ReactiveCustomerRepository extends ReactiveMongoRepository<Customer, ObjectId> {
    Mono<Customer> findById(ObjectId id);
}
