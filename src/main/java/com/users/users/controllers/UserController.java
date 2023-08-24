package com.users.users.controllers;

import com.users.users.dao.UserDao;
import com.users.users.models.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @RequestMapping(value = "user/{id}")
    public User getUser(@PathVariable Long id){
        User user = new User();
        user.setId(id);
        user.setName("Riquelmi");
        user.setLastname("Palacios");
        user.setEmail("riccieripalacios@gmail.com");
        user.setPhone("7583-5200");
        return user;
    }

    @RequestMapping(value = "users")
    public List<User> getUsers(){
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setId(1L);
        user.setName("Riquelmi");
        user.setLastname("Palacios");
        user.setEmail("riccieripalacios@gmail.com");
        user.setPhone("7583-5200");

        User user2 = new User();
        user2.setId(2L);
        user2.setName("Riquelmi");
        user2.setLastname("Palacios");
        user2.setEmail("riccieripalacios@gmail.com");
        user2.setPhone("7583-5200");

        User user3 = new User();
        user3.setId(3L);
        user3.setName("Riquelmi");
        user3.setLastname("Palacios");
        user3.setEmail("riccieripalacios@gmail.com");
        user3.setPhone("7583-5200");

        users.add(user);
        users.add(user2);
        users.add(user3);
        return users;
    }


}
