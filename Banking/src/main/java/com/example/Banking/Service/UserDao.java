package com.example.Banking.Service;

import com.example.Banking.Exception.IdNotFound;
import com.example.Banking.Model.User;

import java.util.List;


public interface UserDao  {

    List<User> getUsers() ;

    User getUser(long id) throws IdNotFound ;


    void insertUser(User user) ;


    void updateUser(User user, long id) throws IdNotFound;


    void deleteUser(long id)  ;


}

