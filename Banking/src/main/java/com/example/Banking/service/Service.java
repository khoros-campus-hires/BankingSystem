package com.example.Banking.service;

import com.example.Banking.Exception.IdNotFound;
import com.example.Banking.Model.User;
import com.example.Banking.Model.UserTranasaction;
import com.example.Banking.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDao userDao;

    //get
    public List<User> getEveryUser(){
        return userDao.getAll();
    }


    //getById
    public Optional<User> getOneAccount(long id){
        return userDao.getAccount(id);
    }

    //transaction
    public String transaction(Long senderId, UserTranasaction sender) throws Exception {
        //User senderAccount = userRepository.findById(senderId)
        //       .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + senderId));
        User senderAccount = userRepository.findById(senderId)
                .orElseThrow(() -> new IdNotFound("Sender Account id not found") );

        User recieverAccount = userRepository.findById(sender.getReceiverId())
                .orElseThrow(() -> new IdNotFound("Reciver account id not found") );

        if( senderAccount.getAccountNumber() == sender.getFromAccount())
        {
            if(recieverAccount.getAccountNumber() == sender.getToAccount() )
            {
                if( senderAccount.getBalance() > sender.getTransferAmount()) {
                    long balance = senderAccount.setBalance(senderAccount.getBalance() - sender.getTransferAmount());
                    senderAccount.setBalance(balance);
                    userRepository.save(senderAccount);
                }
                else {
                    return new TransactionStatus().returnMsg("Transaction Failed due to insuficient balance");
                }
                recieverAccount.setBalance(recieverAccount.getBalance() + sender.getTransferAmount());
                userRepository.save(recieverAccount);
            }
            else return new TransactionStatus().returnMsg("Reciver account is not available");
        }
        else return new TransactionStatus().returnMsg("Sender Account is not available");

        return new TransactionStatus().returnMsg("Transaction Sucess");

    }

}
