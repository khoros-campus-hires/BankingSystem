package com.example.Banking.service;

import com.example.Banking.exception.IdNotFoundException;
import com.example.Banking.model.Account;
import com.example.Banking.model.Transaction;
import com.example.Banking.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class TransactionServiceTests {

    @MockBean
    private AccountDao accountDao;

    @MockBean
    private Transaction transaction;

    @MockBean
    private AccountRepository accountRepository;

    @Test
    void transactionUserDetailsTest() throws IdNotFoundException {

        Account sender = new Account();
        sender.setAccountNumber(234542213);
        sender.setBranchName("kailasha branch");
        sender.setBankName("Bank of kailash");
        sender.setAccountBalance(78235242);
        sender.setCifNumber(5646);
        sender.setId(789);
        sender.setIfscCode("kailash0123");
        when(accountDao.getAccount(anyLong())).thenReturn(sender);


        Account senderAcc = accountDao.getAccount(234542213);
        assertEquals(234542213, senderAcc.getAccountNumber());
        assertNotEquals(234542214, senderAcc.getAccountNumber());

    }


    @Test
    void transactionIdNotFoundExceptiontTest() throws IdNotFoundException {
        when(accountDao.getAccount(anyLong())).thenReturn(null);
        Account senderAcc = accountDao.getAccount(234542213);
        assertThrows(NullPointerException.class, () -> {
            senderAcc.getAccountNumber();
        });
    }


}