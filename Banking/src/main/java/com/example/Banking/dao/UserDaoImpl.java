package com.example.Banking.dao;

import com.example.Banking.exception.IdNotFoundException;
import com.example.Banking.model.User;
import com.example.Banking.model.UserTransaction;
import com.example.Banking.repository.TransactionRepository;
import com.example.Banking.repository.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class UserDaoImpl  implements UserDao{


    @NonNull
    private UserRepository userRepository;
    @NonNull
    private TransactionRepository transactionRepository;

    @Override
    public Optional<User> getAccount(long phoneNumber) {
        return userRepository.findById(phoneNumber);
    }


    @Override
    public User getAccountByAccountNumber(long AccountNumber) throws IdNotFoundException {
             try{
              return userRepository.findByAccNo(AccountNumber);
             }
             catch(Exception e)
             { throw new IdNotFoundException("Receiver account is not found");
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

    @Override
    public void insertTransactionTable(UserTransaction sender) {
        transactionRepository.save(sender);
    }


}