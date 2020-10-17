package com.example.Banking.Controller;
import com.example.Banking.Model.User;
import com.example.Banking.Model.UserTranasaction;
import com.example.Banking.service.Service;
import com.example.Banking.service.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/Users")
public class UserController {

    @Autowired
    private Service service;
    //@Autowired
    //private UserDao userDao;

    @GetMapping("/getAll")
    public List<User> getAllAccountDetails() {
        return service.getEveryUser();
    }

    @GetMapping("/getone/{id}")
    public Optional<User> getOneAccount(@PathVariable(value = "id") Long accountId) {
        return service.getOneAccount(accountId);
    }

    //Transaction
    @PutMapping("/transaction/{id}")
    public String transactionService(@PathVariable(value = "id") Long senderId,@RequestBody UserTranasaction sender) throws Exception {
       return service.transaction(senderId,sender);
    }

}
