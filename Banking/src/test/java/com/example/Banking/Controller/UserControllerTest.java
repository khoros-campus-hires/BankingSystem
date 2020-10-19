package com.example.Banking.Controller;

import com.example.Banking.Model.User;
import com.example.Banking.Service.UserService;
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

import static org.junit.jupiter.api.Assertions.*;


@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAllUsersTest() throws Exception {
        List<User> users = new ArrayList<>();
        users.add(new User(1212121212, "manas", "vini", 21, "10,chennai", 999999999, "m@mail.com"));
        //users.add(new User(17,"vini"));
        Mockito.when(userService.getAll()).thenReturn(users);

        /*String url = "/Users/getUsers";
        MvcResult mvcResult = mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();
        String actualJsonResponse = mvcResult.getResponse().getContentAsString();
        System.out.println(actualJsonResponse);
        String expectedResponse = objectMapper.writeValueAsString(users);
        Assertions.assertThat(actualJsonResponse).isEqualToIgnoringWhitespace(expectedResponse);*/
        String url = "/Users/GetAllUsers";
        RequestBuilder rb = MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(rb).andReturn();
        String actualResponse = mvcResult.getResponse().getContentAsString();

        System.out.println(actualResponse);

        String expectedResponse = objectMapper.writeValueAsString(users);
        Assertions.assertThat(actualResponse).isEqualToIgnoringWhitespace(expectedResponse);
    }
}

