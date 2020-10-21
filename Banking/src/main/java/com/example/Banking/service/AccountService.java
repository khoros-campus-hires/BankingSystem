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

    public Account getAccountbyId(Long acNumber) throws IdNotFoundException {
        return accountDao.getAccount(acNumber);
    }

    public void createAccount(Account account) {
         accountDao.insertAccount(account);
    }

    public void deleteAccountbyId(Long acNumber) throws IdNotFoundException {
        accountDao.deleteAccount(acNumber);
    }

    public void updateAccountbyId(Account account) throws IdNotFoundException {
        accountDao.updateAccount(account);
    }
}
