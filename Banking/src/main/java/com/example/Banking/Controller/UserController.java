package com.example.Banking.Controller;

import java.util.List;
import java.util.Optional;

import com.example.Banking.Exception.ResourceNotFoundException;
import com.example.Banking.Model.User;
import com.example.Banking.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Users")
public class UserController {

    @Autowired
    private UserDaoImpl userDaoImpl;

    @PutMapping("/transaction/{id}")
        public String transaction(@PathVariable(value = "id") Long userId, @RequestBody User userAmount) {
        userDaoImpl.transaction(userId, userAmount );
    }
    /*
     {
        "id": 345,
        "firstName": "Nithi",
        "lastName": "nandha",
        "dob": "2017-06-15",
        "age": 104,
        "address": "kailasa",
        "contact_number": 9999999999,
        "email": "nithi@kailash.com"
    }
    */
}
