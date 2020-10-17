package com.example.Banking.service;

import com.example.Banking.Model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


public interface UserDao {



    public List<User> getAll( );
    Optional<User> getAccount(long id);

}
