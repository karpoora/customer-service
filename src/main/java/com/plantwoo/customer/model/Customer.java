package com.plantwoo.customer.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Document
public class Customer {
    @Id
    private ObjectId _id;
    private String name;
    private String gender;
    private String address;
    private String city;
    private String state;
    private String country;
    private String email;
    private String userName;
    private String password;
    private String mobile;
}
