package com.example.Banking.Controller;

import com.example.Banking.Model.User;
import com.example.Banking.Model.UserTranasaction;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.util.ArrayList;
import java.util.List;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Service service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAllAccountDetails() throws Exception {

        List<User> users = new ArrayList<>();
        users.add(new User(454,24532459,983779));
        users.add(new User(456,24532458,1111111));
        users.add(new User(458,24532457,1238443));
        Mockito.when(service.getEveryUser()).thenReturn(users);

        String url = "/Users/getAll";
        RequestBuilder rb = MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(rb).andReturn();
        String actualResponse = mvcResult.getResponse().getContentAsString();

        System.out.println(actualResponse);

        String expectedResponse = objectMapper.writeValueAsString(users);
        Assertions.assertThat(actualResponse).isEqualToIgnoringWhitespace(expectedResponse);
    }


    @Test
    void transactionTest() throws Exception{
        UserTranasaction userTranasactions  = new UserTranasaction( 24532459,24532457,1111);
        Mockito.when(service.transaction((long) 454,userTranasactions)).thenReturn(String.valueOf(userTranasactions));

        String url = "/Users/transaction/454";
        RequestBuilder rb = MockMvcRequestBuilders.put(url).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userTranasactions));

        MvcResult mvcResult = mockMvc.perform(rb).andReturn();

        Assertions.assertThat(objectMapper.writeValueAsString(userTranasactions))
                .isEqualToIgnoringWhitespace(mvcResult.getResponse().getContentAsString());
    }



}