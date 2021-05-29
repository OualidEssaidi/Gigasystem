package com.gigasystem.Customers.repository;

import com.gigasystem.Customers.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer findById(long id);

    Customer findByFirstName(String firstName);
}
