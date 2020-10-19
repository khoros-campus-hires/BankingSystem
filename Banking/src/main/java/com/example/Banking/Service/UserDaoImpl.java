package com.example.Banking.Service;
import com.example.Banking.Exception.IdNotFound;
import com.example.Banking.Model.User;
import com.example.Banking.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    UserRepository userRepository;
    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(long id) throws IdNotFound {

        return userRepository.findById(id)
                .orElseThrow(() -> new IdNotFound("User not found for this id :: " + id));
    }

    @Override
    public void insertUser(User user)  {
        userRepository.save(user);

    }

    @Override
    public void updateUser(User user, long id) throws IdNotFound {
        User u = userRepository.findById(id)
        .orElseThrow(() -> new IdNotFound("User not found for this id :: " + id));

        u.setFirstName(user.getFirstName());
        u.setLastName(user.getLastName());
        u.setAge(user.getAge());
        u.setAddress(user.getAddress());
        u.setContact_number(user.getContact_number());
        u.setEmail(user.getEmail());
        userRepository.save(user);

    }

    @Override
    public void deleteUser(long id) throws IdNotFound{

        if(userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
        else
        {
            throw new IdNotFound("Account is not Found for this id");
        }


    }
}