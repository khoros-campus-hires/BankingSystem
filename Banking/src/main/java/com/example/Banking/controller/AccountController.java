package com.example.Banking.controller;
import com.example.Banking.exception.IdNotFoundException;
import com.example.Banking.model.Account;
import com.example.Banking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.List;

@RestController
@RequestMapping("/Accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @GetMapping("/getAllAccounts")
    public List<Account> getAllAccounts() {
        return accountService.getEveryAccount();
    }

    @GetMapping("/getOneAccount/{accountNumber}")
    public Account getOneAccount(@PathVariable(value = "accountNumber") Long acNumber) throws IdNotFoundException {
        return accountService.getAccountByAcNumber(acNumber);
    }

    @PostMapping("/createAccount")
    public void createAccounts(@RequestBody Account account) {
        accountService.createAccount(account);

    }

    @DeleteMapping("/deleteAccount/{accountNumber}")
    public void deleteAccount(@PathVariable(value = "accountNumber") Long acNumber) throws IdNotFoundException {

        accountService.deleteAccountByAcNumber(acNumber);

    }

    @PutMapping("/updateAccount")
    public void updateAccount(@RequestBody Account account) throws IdNotFoundException {
        accountService.updateAccount(account);

    }
}
