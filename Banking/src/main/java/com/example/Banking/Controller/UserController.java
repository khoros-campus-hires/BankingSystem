package com.example.Banking.Controller;

import java.util.List;
import java.util.Optional;

import com.example.Banking.Dao.UserDaoImpl;
import com.example.Banking.Exception.ResourceNotFoundException;
import com.example.Banking.Model.User;
//import lombok.NonNull;
//import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/Users")
//@RequiredArgsConstructor
public class UserController {
     @Autowired
    //@NonNull
    private UserDaoImpl userDao;

    @GetMapping("/GetAllUsers")
    public List<User> getAllUsers() {
        return userDao.getUsers();
    }

    @GetMapping("/GetOneUser/{id}")
    public Optional<User> getOneUser(@PathVariable(value = "id") Long userId) {
        return userDao.getUser(userId);
    }

    @PostMapping("/CreateUser")
    public void createUser(@RequestBody User user) {
        userDao.insertUser(user);

    }

    @DeleteMapping("/DeleteUser/{id}")
    public void deleteUser(@PathVariable(value = "id") Long userId) {

        userDao.deleteUser(userId);

    }

    @PutMapping("/UpdateUser/{id}")
    public void updateEmployee(@PathVariable(value = "id") Long userId, @RequestBody User user) {
        userDao.updateUser(user, userId);

    }
}