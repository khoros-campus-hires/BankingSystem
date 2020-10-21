package com.example.Banking.service;

import com.example.Banking.exception.IdNotFoundException;
import com.example.Banking.model.User;

import java.util.List;


public interface UserDao  {

    List<User> getUsers() ;

    User getUser(long id) throws IdNotFoundException;

    void insertUser(User user) ;

    void updateUser(User user) throws IdNotFoundException;

    void deleteUser(long id) throws IdNotFoundException;

}
