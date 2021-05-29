package com.gigasystem.Users.service;

import com.gigasystem.Users.model.User;
import com.gigasystem.Users.repository.UserRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    public boolean isExist(long id){
        return this.userRepo.existsById(id);
    }

    public User getOneById(long id){
        return userRepo.findById(id);
    }


    public User getOneByName(String name){
        return this.userRepo.findByName(name);
    }


    public Iterable<User> getAll(){
        return this.userRepo.findAll();
    }


    public User addNewUser(User newUser){
        return this.userRepo.save(newUser);
    }


    public void deleteUser(long id) {
        userRepo.deleteById(id);
    }

    public User updateUser(long id) {
        User user = this.userRepo.findById(id);
        user.setLogin("Hamza");
        user.setRole("USER");
        return this.userRepo.save(user);
    }
}
