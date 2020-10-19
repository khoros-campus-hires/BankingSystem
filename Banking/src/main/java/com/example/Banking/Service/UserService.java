package com.example.Banking.Service;

import com.example.Banking.Exception.IdNotFound;
import com.example.Banking.Model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@org.springframework.stereotype.Service
public class UserService {

    @Autowired
    private UserDaoImpl userDao;

    public List<User> getAll() {
        return userDao.getUsers();
    }

    public User getUserbyId(Long Id) throws IdNotFound {
        return userDao.getUser(Id);
    }

    public void CreateUser(User user) {
        userDao.insertUser(user);
    }

    public void deleteUser(Long Id) {
        userDao.deleteUser(Id);
    }

    public void updateUser(User user, Long Id) throws Exception{
        userDao.updateUser(user,Id);
    }
}

