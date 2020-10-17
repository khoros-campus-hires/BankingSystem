package com.example.Banking.service;

import com.example.Banking.Model.User;
import com.example.Banking.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserDaoImpl  implements UserDao{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getAccount(long id) {
        return userRepository.findById(id);
    }
}
