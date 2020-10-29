package com.example.Banking.service;

import com.example.Banking.exception.IdNotFoundException;
import com.example.Banking.model.Account;
import com.example.Banking.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private AccountRepository accountRepository;

    private static final String ERROR_MESSAGE = "Account is not Found for this ";

    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }


    public Account getAccount(long acNumber) throws IdNotFoundException {

        return accountRepository.findById(acNumber).orElseThrow(() -> new IdNotFoundException(ERROR_MESSAGE + " " + acNumber));

    }

    @Override
    public void insertAccount(Account account) {
        accountRepository.save(account);

    }

    @Override
    public void deleteAccount(long acNumber) throws IdNotFoundException {
        if (accountRepository.existsById(acNumber)) {
            accountRepository.deleteById(acNumber);
        } else {
            throw new IdNotFoundException(ERROR_MESSAGE + " " + acNumber);
        }
    }

    @Override
    public void updateAccount(Account account) throws IdNotFoundException {
        Account accountsfromDB = accountRepository.findById(account.getAccountNumber()).orElseThrow(() -> new IdNotFoundException(ERROR_MESSAGE + " " + account.getAccountNumber()));
        accountsfromDB.setAccountType(account.getAccountType());
        accountsfromDB.setBranchName(account.getBranchName());
        accountsfromDB.setAccountBalance(account.getAccountBalance());
        accountsfromDB.setIfscCode(account.getIfscCode());
        accountsfromDB.setCifNumber(account.getCifNumber());
        accountRepository.save(account);

    }


}
