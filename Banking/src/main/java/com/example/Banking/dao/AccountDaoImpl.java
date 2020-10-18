package com.example.Banking.dao;
import com.example.Banking.exception.IdNotFound;
import com.example.Banking.model.Account;
import com.example.Banking.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private AccountRepository accountRepository;


    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    public Optional<Account> getAccount(long id) {

        return accountRepository.findById(id);
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
        Account accounts = accountRepository.findById(AcNumber).orElseThrow(() -> new IdNotFound("Id not Found"));
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
