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

    @PutMapping("/transaction")
    public String transactionService(@RequestBody UserTransaction sender) throws Exception {
        return service.transaction(sender);
    }

}
