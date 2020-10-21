package com.example.Banking.controller;

import com.example.Banking.model.Transaction;
import com.example.Banking.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class TransactionController {

    @Autowired
    private TransactionService service;

    @PutMapping("/transaction")
    public String transactionService(@RequestBody Transaction sender) throws Exception {
        return service.transaction(sender);
    }

}
