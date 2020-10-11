package com.example.Banking.Controller;

import java.util.List;
import java.util.Optional;


import com.example.Banking.Exception.ResourceNotFoundException;
import com.example.Banking.Model.User;
import com.example.Banking.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/Users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/GetAllUsers")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/GetOneUser/{id}")
    public Optional<User> getOneUser(@PathVariable(value = "id") Long userId) {
        return userRepository.findById(userId);
    }

    @PostMapping("/CreateUser")
    public String createUser(@RequestBody User user) {
         userRepository.save(user);
         return "User details inserted successfully";
    }

    @DeleteMapping("/DeleteUser/{id}")
    public String deleteUser(@PathVariable(value = "id") Long userId){

        userRepository.deleteById(userId);
        return "User deleted successfully";

    }

    @PutMapping("/UpdateUser/{id}")
    public String updateEmployee(@PathVariable(value = "id") Long userId,
                                @RequestBody User userDetails) throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));



        user.setfirstName(userDetails.getfirstName());
        user.setlastName(userDetails.getlastName());
        user.setDob((userDetails.getDob()));
        user.setAge(userDetails.getAge());
        user.setAddress(userDetails.getAddress());
        user.setContact_number(userDetails.getContact_number());
        user.setEmail((userDetails.getEmail()));
        userRepository.save(user);
        return "User details updated successfully";
    }
}
