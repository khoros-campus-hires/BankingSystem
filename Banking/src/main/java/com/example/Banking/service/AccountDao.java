package com.example.Banking.service;

import com.example.Banking.exception.IdNotFound;
import com.example.Banking.model.Account;
import java.util.List;

public interface AccountDao {
    public List<Account> getAll( );
    Account getAccount(long id) throws IdNotFound;
    void insertAccount(Account account);
    void deleteAccount(long id);
    void updateAccount(Account account, long id) throws IdNotFound;

}
