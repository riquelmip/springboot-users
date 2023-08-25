package com.users.users.controllers;

import com.users.users.dao.UserDao;
import com.users.users.models.User;

import com.users.users.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private JWTUtil jwtUtil;
    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody User user) {

        User userLog = userDao.getUserCredentials(user);
        if (userLog != null) {
            String tokenJwt = jwtUtil.create(String.valueOf(userLog.getId()), userLog.getEmail());
            return tokenJwt;
        }
        return "FAIL";
    }
}
