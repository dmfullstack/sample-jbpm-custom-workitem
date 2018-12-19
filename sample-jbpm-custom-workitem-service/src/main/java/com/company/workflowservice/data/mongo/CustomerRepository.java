package com.company.workflowservice.data.mongo;

import com.company.workflowservice.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository("customerRepository")
public interface CustomerRepository extends MongoRepository<Customer, String> {

}
