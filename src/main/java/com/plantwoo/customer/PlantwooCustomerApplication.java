package com.plantwoo.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class PlantwooCustomerApplication {
    public static void main(String[] args) {
        SpringApplication.run(PlantwooCustomerApplication.class, args);
    }

}
