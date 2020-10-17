package com.example.Banking.service;

import com.example.Banking.Exception.IdNotFound;
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


    @Override
    public User getAccountByAccountNumber(long AccountNumber) throws IdNotFound {
        try {
            User recieverAcc = userRepository.findByAccNo(AccountNumber);
            return recieverAcc;

        }
        catch (Exception e)
        {
            throw new IdNotFound(" imjo");
        }

    }


    @Override
    public void updateBalance(long sender_bal, User sender) throws Exception {
        sender.setBalance(sender.getBalance() - sender_bal);
        userRepository.save(sender);
    }

    @Override
    public void updateReceiverBalance(long receiverAmount, User reciever) {
        reciever.setBalance(reciever.getBalance() + receiverAmount);
        userRepository.save(reciever);
    }


}