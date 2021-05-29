package com.gigasystem.Customers.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;
    private String lastName;
    private String city;
    private String email;
    private String phone;

    public Customer() { }

    public Customer(String firstName, String lastName, String city, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.email = email;
        this.phone = phone;
    }
}
