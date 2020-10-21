package com.example.Banking.controller;

import java.util.List;


import com.example.Banking.model.User;
import com.example.Banking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/Users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/GetAllUsers")
    public List<User> getAllUsers() {

        return userService.getAll();
    }

    @GetMapping("/GetOneUser/{id}")
    public User getOneUser(@PathVariable(value = "id") Long userId) throws Exception {

        return userService.getUserById(userId);
    }

    @PostMapping("/CreateUser")
    public void createUser(@RequestBody User user) {

        userService.createUser(user);

    }

    @DeleteMapping("/DeleteUser/{id}")
    public void deleteUser(@PathVariable(value = "id") Long userId) throws Exception {

        userService.deleteUser(userId);

    }

    @PutMapping("/UpdateUser")
    public void updateUser( @RequestBody User user) throws Exception {

        userService.updateUser(user);

    }
}