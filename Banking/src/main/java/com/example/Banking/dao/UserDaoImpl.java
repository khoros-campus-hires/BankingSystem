package com.example.example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.example.Repository.UserRepository;

public class UserDaoImpl implements UserDao {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String transaction (  Long userId, User userAmount ) throws ResourceNotFoundException {
        User sender = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
        //deducting
        if( sender.getBalance() > userAmount.getBalance()) {
            long balance = sender.setBalance(sender.getBalance() - userAmount.getBalance());
            sender.setBalance(balance);
            userRepository.save(sender);
        }
        else {
            return "invalid balance";
        }

        //crediting
        User reciever =userRepository.findById(userAmount.getId()).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
        long balance2 = reciever.setBalance(reciever.getBalance() + userAmount.getBalance());
        userRepository.save(reciever);

        return "success";
    }

}
