package com.example.Banking.service;

import com.example.Banking.Exception.IdNotFound;
import com.example.Banking.Model.User;
import com.example.Banking.Model.UserTranasaction;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private UserDao userDao;

    //get
    public List<User> getEveryUser(){
        return userDao.getAll();
    }


    //getById
    public Optional<User> getOneAccount(long id){ return userDao.getAccount(id); }


    //transaction
    public String transaction(Long senderId, UserTranasaction sender) throws Exception {
        User senderAcc = userDao.getAccount(senderId).orElseThrow(() -> new IdNotFound("Sender Account id not found"));
        User recieverAcc = userDao.getAccountByAccountNumber(sender.getToAccount());

        if( senderAcc.getAccountNumber() == sender.getFromAccount() )
        { if( senderAcc.getBalance() > sender.getTransferAmount()) {
            userDao.updateBalance(sender.getTransferAmount(), senderAcc);
        }
        else { return new TransactionStatus().returnMsg("Transaction Failed due to insufficient balance"); }
            userDao.updateReceiverBalance(sender.getTransferAmount(), recieverAcc);
        }
        else { throw new IdNotFound("Sender Account is not available"); }
        return new TransactionStatus().returnMsg("Transaction Success");
    }

}
