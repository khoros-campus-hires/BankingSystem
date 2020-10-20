package com.example.Banking.controller;

import com.example.Banking.model.UserTransaction;
import com.example.Banking.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/Users")
public class UserController {

    @Autowired
    private Service service;

    @PutMapping("/transaction/{phoneNumber}")
    public String transactionService(@PathVariable(value = "phoneNumber") Long phoneNumber,@RequestBody UserTransaction sender) throws Exception {
        return service.transaction(phoneNumber,sender);
    }

}
