package com.example.Banking.controller;

import com.example.Banking.model.Transaction;
import com.example.Banking.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService service;

    @PutMapping("/payment")
    public String transaction(@RequestBody Transaction transactionDetails) throws Exception {
        return service.transaction(transactionDetails);
    }

}
