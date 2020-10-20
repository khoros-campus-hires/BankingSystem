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

    String msg="Account is not Found for this ";

    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }


    public Account getAccount(long acNumber) throws IdNotFoundException {

            return accountRepository.findById(acNumber).orElseThrow(() -> new IdNotFoundException(msg + " "+ acNumber));

    }

    @Override
    public void insertAccount(Account account) {
        accountRepository.save(account);

    }


    @Override
    public void deleteAccount(long acNumber) throws IdNotFoundException {
        if(accountRepository.existsById(acNumber)) {
            accountRepository.deleteById(acNumber);
        }
        else
        {
            throw new IdNotFoundException(msg + " "+ acNumber);
        }
    }

    @Override
    public void updateAccount(Account account, long acNumber) throws IdNotFoundException {
        Account accounts = accountRepository.findById(acNumber).orElseThrow(() -> new IdNotFoundException(msg +" "+acNumber));
        accounts.setAccountNumber(account.getAccountNumber());
        accounts.setAccountType(account.getAccountType());
        accounts.setBankName(account.getBankName());
        accounts.setBranchName(account.getBranchName());
        accounts.setPhoneNumber(account.getPhoneNumber());
        accounts.setAccountBalance(account.getAccountBalance());
        accounts.setIfscCode(account.getIfscCode());
        accounts.setCifNumber(account.getCifNumber());
        accountRepository.save(account);

    }


}
