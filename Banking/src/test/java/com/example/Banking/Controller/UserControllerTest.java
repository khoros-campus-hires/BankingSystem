package com.example.Banking.Controller;

import com.example.Banking.Model.User;
import com.example.Banking.service.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
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

        MvcResult mvcResult = (MvcResult) mockMvc.perform(MockMvcRequestBuilders.get(url)).andExpect(MockMvcResultMatchers.status().isOk());

        String actualResponse = mvcResult.getResponse().getContentAsString();

        System.out.println(actualResponse);

        String expectedResponse = objectMapper.writeValueAsString(users);

        Assertions.assertThat(actualResponse).isEqualToIgnoringWhitespace(expectedResponse);


    }



}