package com.example.Banking.service;

import com.example.Banking.exception.IdNotFoundException;
import com.example.Banking.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@org.springframework.stereotype.Service
public class UserService {

    @Autowired
    private UserDaoImpl userDao;

    public List<User> getAll() {
        return userDao.getUsers();
    }

    public User getUserById(Long Id) throws IdNotFoundException {
        return userDao.getUser(Id);
    }

    public void createUser(User user) {
        userDao.insertUser(user);
    }

    public void deleteUser(Long Id) throws IdNotFoundException {
        userDao.deleteUser(Id);
    }

    public void updateUser(User user) throws IdNotFoundException {
        userDao.updateUser(user);
    }
}



