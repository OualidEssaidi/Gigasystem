package com.gigasystem.Users.repository;

import com.gigasystem.Users.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

    User findById(long id);

    User findByName(String name);

    User findByLogin(String login);
}
