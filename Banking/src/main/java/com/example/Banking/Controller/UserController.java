package com.example.Banking.Controller;

import java.util.List;


import com.example.Banking.Model.User;
import com.example.Banking.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
    public User getOneUser(@PathVariable(value = "id") Long userId) throws Exception{

        return userService.getUserbyId(userId);
    }

    @PostMapping("/CreateUser")
    public void createUser(@RequestBody User user) {
        userService.CreateUser(user);

    }

    @DeleteMapping("/DeleteUser/{id}")
    public void deleteUser(@PathVariable(value = "id") Long userId) {

        userService.deleteUser(userId);

    }

    @PutMapping("/UpdateUser/{id}")
    public void updateEmployee(@PathVariable(value = "id") Long userId, @RequestBody User user) throws Exception {
        userService.updateUser(user, userId);

    }
}