package com.users.users.dao;

import com.users.users.models.User;

import java.util.List;

public interface UserDao {

    List<User> getUsers();

    void delete(Long id);


    void register(User user);

    User getUserCredentials(User user);
}
