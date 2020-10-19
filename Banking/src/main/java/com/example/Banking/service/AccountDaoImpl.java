package com.example.Banking.service;
import com.example.Banking.exception.IdNotFound;
import com.example.Banking.model.Account;
import com.example.Banking.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private AccountRepository accountRepository;


    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }


    public Account getAccount(long id) throws IdNotFound {

            return accountRepository.findById(id).orElseThrow(() -> new IdNotFound("Account is not Found for this id"));

    }

    @Override
    public void insertAccount(Account account) {
        accountRepository.save(account);

    }
    //To delete account
    @Override
    public void deleteAccount(long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public void updateAccount(Account account, long AcNumber) throws IdNotFound {
        Account accounts = accountRepository.findById(AcNumber).orElseThrow(() -> new IdNotFound("Account is not Found for this id"));
        accounts.setAccountNumber(account.getAccountNumber());
        accounts.setAccountType(account.getAccountType());
        accounts.setBankName(account.getBankName());
        accounts.setBranchName(account.getBranchName());
        accounts.setAccountBalance(account.getAccountBalance());
        accounts.setIfscCode(account.getIfscCode());
        accounts.setCifNumber(account.getCifNumber());
        accounts.setInitialPayment(account.getInitialPayment());

        accountRepository.save(account);

    }


}
