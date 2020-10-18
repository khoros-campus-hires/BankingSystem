package com.example.Banking.controller;


import com.example.Banking.dao.AccountDaoImpl;
//import com.example.Banking.exception.ResourceNotFoundException;
import com.example.Banking.model.Account;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v2")

public class AccountController {
    @Autowired
    private AccountDaoImpl accountDao;
    @GetMapping("/GetAllAccounts")
    public List<Account> getAllAccounts() {
        return accountDao.getAll();
    }

    @GetMapping("/GetOneAccount/{id}")
    public Optional<Account> getOneAccount(@PathVariable(value = "id") Long accountId) {
        return accountDao.getAccount(accountId);
    }

    @PostMapping("/CreateAccount")
    public void createAccount(@RequestBody Account account) {
        accountDao.insertAccount(account);

    }

    @DeleteMapping("/DeleteAccount/{id}")
    public void deleteAccount(@PathVariable(value = "id") Long accountId) {

        accountDao.deleteAccount(accountId);

    }


    @PutMapping("/UpdateAccount/{id}")
    public void updateAccount(@PathVariable(value = "id") Long accountId, @RequestBody Account account) throws Exception{
        accountDao.updateAccount(account, accountId);

    }


}
