package com.example.Banking.controller;


import com.example.Banking.exception.ResourceNotFoundException;
import com.example.Banking.model.Account;
import com.example.Banking.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;
    @GetMapping("/getAccountDetails")
    public List<Account> getAllAccountDetails() {
        return accountRepository.findAll();
    }

    @PostMapping("/createAccount")
    public Account createAccount(@RequestBody Account account) {
        return accountRepository.save(account);
    }

    @DeleteMapping("/getAccountDetails/{AccountNumber}")
    public void deleteAccountDetails(@PathVariable(value = "AccountNumber") Long AcNumber){
        accountRepository.deleteById(AcNumber);
    }

    @PutMapping("/updateAccount/{AccountNumber}")
    public void updateAccount(@PathVariable(value = "AccountNumber") Long AcNumber,
                               @RequestBody Account accountDetails) throws ResourceNotFoundException {
        Account accounts = accountRepository.findById(AcNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found for this id :: " + AcNumber));

        //accounts.setAccountNumber(accountDetails.getAccountNumber());
        accounts.setAccountType(accountDetails.getAccountType());
        accounts.setBankName(accountDetails.getBankName());
        accounts.setBranchName(accountDetails.getBranchName());
        accounts.setAccountBalance(accountDetails.getAccountBalance());
        accountRepository.save(accounts);
    }
}
