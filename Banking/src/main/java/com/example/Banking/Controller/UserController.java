package com.example.Banking.Controller;

import java.util.List;


import com.example.Banking.Exception.ResourceNotFoundException;
import com.example.Banking.Model.User;
import com.example.Banking.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;


@RestController
@RequestMapping("/Users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/GetAllUsers")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/CreateUser")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/DeleteUser/{id}")
    public void deleteUser(@PathVariable(value = "id") Long userId){
        userRepository.deleteById(userId);
    }

    @PutMapping("/UpdateUser/{id}")
    public void updateEmployee(@PathVariable(value = "id") Long userId,
                               /*@Valid*/ @RequestBody User userDetails) throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

        user.setM_no(userDetails.getM_no());
        user.setfirstName(userDetails.getfirstName());
        userRepository.save(user);
    }
}
