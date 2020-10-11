package com.example.Banking.controller;


import com.example.Banking.exception.ResourceNotFoundException;
import com.example.Banking.model.Account;
import com.example.Banking.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;
    private Long acNumber;
    private Account accountDetails;

    @GetMapping("/getAccountDetails")
    public List<Account> getAllAccountDetails() {
        return accountRepository.findAll();
    }


    @GetMapping("/getOneAccountDetails/{id}")
    public Optional<Account> getOneUser(@PathVariable(value = "id") Long AcNumber) {
        return accountRepository.findById(AcNumber);
    }
    @PostMapping("/createAccount")
    public Account createAccount(@RequestBody Account account) {
        return accountRepository.save(account);
    }

    @DeleteMapping("/deleteAccountDetails/{id}")
    public void deleteAccountDetails(@PathVariable(value = "id") Long AcNumber){
        accountRepository.deleteById(AcNumber);
    }

    @PutMapping("/updateAccount/{id}")
    public void updateAccount(@PathVariable(value = "id") Long AcNumber,  @RequestBody Account accountDetails) throws ResourceNotFoundException {
        acNumber = AcNumber;
        this.accountDetails = accountDetails;
        Account accounts = accountRepository.findById(AcNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found for this id :: " + AcNumber));

        accounts.setAccountNumber(accountDetails.getAccountNumber());
        accounts.setAccountType(accountDetails.getAccountType());
        accounts.setBankName(accountDetails.getBankName());
        accounts.setBranchName(accountDetails.getBranchName());
        accounts.setAccountBalance(accountDetails.getAccountBalance());
        accounts.setIfscCode(accountDetails.getIfscCode());
        accounts.setCifNumber(accountDetails.getCifNumber());


        accountRepository.save(accounts);
    }
}
