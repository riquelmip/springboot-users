package com.users.users.controllers;

import com.users.users.dao.UserDao;
import com.users.users.models.User;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "api/users", method = RequestMethod.GET)
    public List<User> getUsers(){
       return userDao.getUsers();
    }
    @RequestMapping(value = "api/users", method = RequestMethod.POST)
    public void register(@RequestBody User user){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, user.getPassword());
        user.setPassword(hash);

        userDao.register(user);
    }
    @RequestMapping(value = "api/users/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        userDao.delete(id);
    }


}
