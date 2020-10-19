package com.example.Banking.controller;
import com.example.Banking.exception.IdNotFound;
import com.example.Banking.model.Account;
import com.example.Banking.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Accounts")

public class AccountController {
    @Autowired
    private Service service;
    @GetMapping("/GetAllAccounts")
    public List<Account> getAllAccounts() {
        return service.getEveryAccount();
    }

    @GetMapping("/GetOneAccount/{id}")
    public Account getOneAccount(@PathVariable(value = "id") Long accountId) throws IdNotFound {
        return service.getAccountbyId(accountId);
    }

    @PostMapping("/CreateAccount")
    public void createAccount(@RequestBody Account account) {
        service.CreateAccount(account);

    }

    @DeleteMapping("/DeleteAccount/{id}")
    public void deleteAccount(@PathVariable(value = "id") Long accountId) throws IdNotFound {

        service.deleteAccountbyId(accountId);

    }

    @PutMapping("/UpdateAccount/{id}")
    public void updateAccount(@PathVariable(value = "id") Long accountId, @RequestBody Account account) throws IdNotFound{
        service.updateAccountbyId(account, accountId);

    }
}
