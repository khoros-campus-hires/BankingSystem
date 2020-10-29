package com.example.Banking.service;

import com.example.Banking.exception.IdNotFoundException;
import com.example.Banking.model.Account;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@org.springframework.stereotype.Service
public class AccountService {

    @Autowired
    private AccountDao accountDao;

    public List<Account> getEveryAccount() {
        return accountDao.getAll();
    }

    public Account getAccountByAcNumber(Long acNumber) throws IdNotFoundException {
        return accountDao.getAccount(acNumber);
    }

    public void createAccount(Account account) {
        accountDao.insertAccount(account);
    }

    public void deleteAccountByAcNumber(Long acNumber) throws IdNotFoundException {
        accountDao.deleteAccount(acNumber);
    }

    public void updateAccount(Account account) throws IdNotFoundException {
        accountDao.updateAccount(account);
    }
}
