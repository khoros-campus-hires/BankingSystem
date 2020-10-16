package com.example.Banking.Controller;
import com.example.Banking.Model.User;
import com.example.Banking.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Users")
public class UserController {

    @Autowired
    public Service service;

    @GetMapping("/getAll")
    public List<User> getAllAccountDetails() {
        return service.getEveryUser();
    }

    //Transaction
    @PutMapping("/transaction/{id}")
    public String transactionService(@PathVariable(value = "id") Long senderId,@RequestBody User sender) throws Exception {
       return service.transaction(senderId,sender);
    }

}
