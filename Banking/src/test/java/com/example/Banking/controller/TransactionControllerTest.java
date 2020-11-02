package com.example.Banking.controller;

import com.example.Banking.model.Account;
import com.example.Banking.model.Transaction;
import com.example.Banking.repository.AccountRepository;
import com.example.Banking.service.AccountDao;
import com.example.Banking.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(TransactionController.class)
class TransactionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransactionService service;

    @MockBean
    private Transaction transactionDetails;

    @MockBean
    private AccountDao accountDao;

    @MockBean
    private AccountRepository accountRepository;

    @Test
    void transaction() throws Exception {
        //when(service.transaction(transactionDetails)).thenReturn("Transaction Success");

        Account sender = new Account();
        sender.setAccountNumber(67575663);
        sender.setBranchName("kailasha branch");
        sender.setBankName("Bank of kailash");
        sender.setAccountBalance(1111111);
        sender.setCifNumber(5646);
        sender.setId(789);
        sender.setIfscCode("kailash0123");
        when(accountDao.getAccount(67575663)).thenReturn(sender);

        Account receiver = new Account();
        receiver.setAccountNumber(67575678);
        receiver.setBranchName("kailasha branch");
        receiver.setBankName("Bank of kailash");
        receiver.setAccountBalance(1111111);
        receiver.setCifNumber(5646);
        receiver.setId(789);
        receiver.setIfscCode("kailash0123");
        when(accountDao.getAccount(67575678)).thenReturn(receiver);

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.put("/transaction/payment")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(getArticleInJson());

        mockMvc.perform(builder).andExpect(status().isOk())
                .andExpect(content().string("Transaction Success"));

    }

    private String getArticleInJson() {
        return "{\n" +
                "\t\"fromAccount\":\"67575663\",\n" +
                "\t\"toAccount\":\"67575678\",\n" +
                "\t\"transferAmount\":\"1111\"\n" +
                "}";

    }
}