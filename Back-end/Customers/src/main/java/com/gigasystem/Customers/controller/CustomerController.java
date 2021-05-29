package com.gigasystem.Customers.controller;

import com.gigasystem.Customers.model.Customer;
import com.gigasystem.Customers.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/all")
    public Iterable<Customer> getAll(){
        return this.customerService.getAll();
    }

    @GetMapping("/id/{id}")
    public Customer getById(@PathVariable long id){
        Customer customer = this.customerService.getOneById(id);
        return customer;
    }

    @GetMapping("/name/{name}")
    public Customer getByName(@PathVariable String name){
        Customer customer = this.customerService.getOneByName(name);
        return customer;
    }

    @PutMapping("/add")
    public ResponseEntity<Void> addCustomer(@RequestBody Customer newCustomer){
        Customer customer = this.customerService.addNewCustomer(newCustomer);
        if(customer == null) return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromPath("/customer")
                .path("/id/{id}")
                .buildAndExpand(customer.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable long id){
        Customer customer = this.customerService.updateCustomer(id);
        if(customer == null) return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromPath("/customer")
                .path("/id/{id}")
                .buildAndExpand(customer.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delUser(@PathVariable long id){
        if(!this.customerService.isExist(id)) return ResponseEntity.notFound().build();

        this.customerService.deleteCustomer(id);
        return ResponseEntity.ok().build();
    }
}
