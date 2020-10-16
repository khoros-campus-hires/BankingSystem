package com.example.Banking.service;

import com.example.Banking.Exception.IdNotFound;
import com.example.Banking.Exception.ResourceNotFoundException;
import com.example.Banking.Model.User;
import com.example.Banking.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private UserRepository userRepository;



    //get
    public List<User> getEveryUser(){
        return userRepository.findAll();
    }

    //transaction
    public String transaction(Long senderId, User sender) throws Exception {
        //User senderAccount = userRepository.findById(senderId)
         //       .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + senderId));
        User senderAccount = userRepository.findById(senderId)
                .orElseThrow(() -> new IdNotFound("sender id not found"));
        //deducting
        if( senderAccount.getBalance() > sender.getBalance()) {
            long balance = senderAccount.setBalance(senderAccount.getBalance() - sender.getBalance());
            senderAccount.setBalance(balance);
            userRepository.save(senderAccount);
        }
        else {
            return new TransactionStatus().returnMsg("Transaction FAiled due to insuficient balance");
        }

        //crediting
        User reciever =userRepository.findById(sender.getId()).orElseThrow(() -> new IdNotFound("reciever id not found"));
        long balance2 = reciever.setBalance(reciever.getBalance() + sender.getBalance());
        userRepository.save(reciever);

        return new TransactionStatus().returnMsg("Transaction Sucess");
    }

}
