package com.quintrix.jfs.customer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.quintrix.jfs.customer.documents.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    // 
}