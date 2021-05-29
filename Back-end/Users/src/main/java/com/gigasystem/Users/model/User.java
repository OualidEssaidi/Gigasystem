package com.gigasystem.Users.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String login;
    private String pass;
    private String role;

    public User() {
    }

    public User(String name, String login, String pass, String role) {
        this.name = name;
        this.login = login;
        this.pass = pass;
        this.role = role;
    }
}
