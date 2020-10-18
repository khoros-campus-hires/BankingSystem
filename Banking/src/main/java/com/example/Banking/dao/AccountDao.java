package com.example.Banking.dao;

import com.example.Banking.exception.IdNotFound;
import com.example.Banking.model.Account;
//package com.example.Banking.controller;
import java.util.List;
import java.util.Optional;

public interface AccountDao {
    public List<Account> getAll( );
    Optional<Account> getAccount(long id);
    void insertAccount(Account account);
    void deleteAccount(long id);
    void updateAccount(Account account, long id) throws IdNotFound;

}
