package com.example.Banking.service;

import com.example.Banking.Exception.IdNotFound;
import com.example.Banking.Model.User;

import java.util.List;
import java.util.Optional;


public interface UserDao {

    public List<User> getAll( );
    Optional<User> getAccount(long id);

        User getAccountByAccountNumber ( long AccountNumber) throws IdNotFound;

    public void updateBalance( long sender_bal,User sender) throws Exception;
    public void updateReceiverBalance(long receiverAmount, User reciever ) throws Exception;



}
