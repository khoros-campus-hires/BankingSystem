package com.example.Banking.service;
import com.example.Banking.exception.IdNotFoundException;
import com.example.Banking.model.User;
import com.example.Banking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    UserRepository userRepository;

    private static final String ERRORMESSAGE = "user not found for this id";

    @Override
    public List<User> getUsers() {

        return userRepository.findAll();
    }

    @Override
    public User getUser(long id) throws IdNotFoundException {

        return userRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException(ERRORMESSAGE+" : "+id));
    }

    @Override
    public void insertUser(User user)  {

        userRepository.save(user);

    }

    @Override
    public void updateUser(User user, long id) throws IdNotFoundException {

        User u = userRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException(ERRORMESSAGE+" : "+id));

        u.setFirstName(user.getFirstName());
        u.setLastName(user.getLastName());
        u.setDob(user.getDob());
        //u.setAge(user.getAge());
        u.setAddress(user.getAddress());
        u.setContact_number(user.getContact_number());
        u.setEmail(user.getEmail());
        userRepository.save(user);

    }

    @Override
    public void deleteUser(long id) throws IdNotFoundException{

        if(userRepository.existsById(id)) {

            userRepository.deleteById(id);

        }
        else
        {
            throw new IdNotFoundException(ERRORMESSAGE+" : "+id);
        }


    }
}