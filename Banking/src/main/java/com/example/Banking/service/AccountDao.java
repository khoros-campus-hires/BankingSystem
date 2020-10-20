package com.example.Banking.service;

import com.example.Banking.exception.IdNotFoundException;
import com.example.Banking.model.Account;
import java.util.List;

public interface AccountDao {
    public List<Account> getAll( );
    Account getAccount(long acNumber) throws IdNotFoundException;
    void insertAccount(Account account);
    void deleteAccount(long acNumber) throws IdNotFoundException;
    void updateAccount(Account account, long acNumber) throws IdNotFoundException;

}
