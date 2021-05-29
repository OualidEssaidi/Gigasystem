package com.gigasystem.Users.controller;

import com.gigasystem.Users.model.User;
import com.gigasystem.Users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public Iterable<User> getUsers(){
        return this.userService.getAll();
    }

    @GetMapping("/id/{id}")
    public User getUserById(@PathVariable long id){
        User user =  this.userService.getOneById(id);
        return user;
    }

    @GetMapping("/name/{name}")
    public User getUserByName(@PathVariable String name){
        return this.userService.getOneByName(name);
    }

    //Rep avec statut correct
    @PutMapping("/add")
    public ResponseEntity<Void> addUser(@RequestBody User newUser){
        User user = this.userService.addNewUser(newUser);
        if(user == null) return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .buildAndExpand(user.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable long id){
        User user = this.userService.updateUser(id);
        if(user == null) return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .buildAndExpand(user.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delUser(@PathVariable long id){
        if(!this.userService.isExist(id))
            return ResponseEntity.notFound().build();

        this.userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

}
