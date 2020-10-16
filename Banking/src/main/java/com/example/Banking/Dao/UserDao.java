package com.example.Banking.Dao;

import com.example.Banking.Model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


public interface UserDao  {

    List<User> getUsers() ;

    Optional<User> getUser(long id) ;


    void insertUser(User user) ;


    void updateUser(User user, long id) ;


    void deleteUser(long id) ;


}

