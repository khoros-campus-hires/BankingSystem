package com.example.Banking.controller;

import com.example.Banking.model.Account;
import com.example.Banking.service.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;



import java.util.ArrayList;
import java.util.List;

@WebMvcTest(AccountController.class)
class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Service service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAllAccountDetails() throws Exception {

        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account(1888888885,654565552,"Savings","IndianBank","Velur",5000,"IDIB000K078",322004562,0));
        Mockito.when(service.getEveryAccount()).thenReturn(accounts);

        String url = "/Accounts/GetAllAccounts";
        RequestBuilder rb = MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(rb).andReturn();
        String actualResponse = mvcResult.getResponse().getContentAsString();

        System.out.println(actualResponse);

        String expectedResponse = objectMapper.writeValueAsString(accounts);
        Assertions.assertThat(actualResponse).isEqualToIgnoringWhitespace(expectedResponse);
    }



}

