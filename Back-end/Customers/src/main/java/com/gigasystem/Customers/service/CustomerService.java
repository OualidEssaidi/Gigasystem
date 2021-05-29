package com.gigasystem.Customers.service;

import com.gigasystem.Customers.model.Customer;
import com.gigasystem.Customers.repository.CustomerRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public boolean isExist(long id){
        return this.customerRepository.existsById(id);
    }

    public Iterable<Customer> getAll(){
        return this.customerRepository.findAll();
    }

    public Customer getOneById(long id){
        return this.customerRepository.findById(id);
    }

    public Customer getOneByName(String name){
        return this.customerRepository.findByFirstName(name);
    }

    public Customer addNewCustomer(Customer customer){
        return this.customerRepository.save(customer);
    }

    public Customer updateCustomer(long id){
        Customer customer = this.customerRepository.findById(id);
        customer.setCity("Fes");
        customer.setFirstName("KHALID");

        return this.customerRepository.save(customer);
    }

    public void deleteCustomer(long id){
        this.customerRepository.deleteById(id);
    }


}
