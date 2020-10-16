package com.example.Banking.dao;
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
    private Account accountDetails;

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
    public void updateAccount(Account account, long AcNumber) {
        Account accounts = accountRepository.findById(AcNumber).orElse(null);
        //.orElseThrow(() -> new ResourceNotFoundException("Account not found for this id :: " + AcNumber));
        //assert accounts != null;
        accounts.setAccountNumber(accountDetails.getAccountNumber());
        accounts.setAccountType(accountDetails.getAccountType());
        accounts.setBankName(accountDetails.getBankName());
        accounts.setBranchName(accountDetails.getBranchName());
        accounts.setAccountBalance(accountDetails.getAccountBalance());
        accounts.setIfscCode(accountDetails.getIfscCode());
        accounts.setCifNumber(accountDetails.getCifNumber());
        accounts.setInitialPayment(accountDetails.getInitialPayment());

        accountRepository.save(accounts);

    }


}
