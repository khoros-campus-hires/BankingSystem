package com.example.Banking.dao;

import com.example.Banking.exception.IdNotFoundException;
import com.example.Banking.model.Account;
import com.example.Banking.model.UserTransaction;

import java.util.Optional;


public interface UserDao {

    Optional<Account> getAccount(long phoneNumber);
    User getAccountByAccountNumber ( long AccountNumber) throws IdNotFoundException;
    public void updateBalance( long sender_bal,User sender) throws Exception;
    public void updateReceiverBalance(long receiverAmount, User reciever ) throws Exception;
    public void insertTransactionTable(UserTransaction sender);
}
