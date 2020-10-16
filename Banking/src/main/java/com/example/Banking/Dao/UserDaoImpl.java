package com.example.Banking.Dao;
import com.example.Banking.Exception.ResourceNotFoundException;
import com.example.Banking.Model.User;
import com.example.Banking.Repository.UserRepository;
//import lombok.NonNull;
//import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.List;


//@RequiredArgsConstructor
@Component
public class UserDaoImpl implements UserDao {

    //@NonNull
    @Autowired
    UserRepository userRepository;
    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(long id) {

        return userRepository.findById(id) ;
    }

    @Override
    public void insertUser(User user)  {
        userRepository.save(user);

    }

    @Override
    public void updateUser(User user, long id) {
        User u = userRepository.findById(id).orElse(null);
        //.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));

        assert u != null;
        u.setFirstName(user.getFirstName());
        u.setLastName(user.getLastName());
        u.setAge(user.getAge());
        u.setAddress(user.getAddress());
        u.setContact_number(user.getContact_number());
        u.setEmail(user.getEmail());
        userRepository.save(user);

    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}