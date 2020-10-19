package com.example.Banking.service;

import com.example.Banking.exception.IdNotFound;
import com.example.Banking.model.Account;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private AccountDao accountDao;

    public List<Account> getEveryAccount() {
        return accountDao.getAll();
    }

    public Account getAccountbyId(Long accountId) throws IdNotFound {
        return accountDao.getAccount(accountId);
    }

    public void CreateAccount(Account account) {
         accountDao.insertAccount(account);
    }

    public void deleteAccountbyId(Long accountId) throws IdNotFound {
        accountDao.deleteAccount(accountId);
    }

    public void updateAccountbyId(Account account, Long accountId) throws Exception{
        accountDao.updateAccount(account,accountId);
    }
}
