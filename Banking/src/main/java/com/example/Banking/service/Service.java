package com.example.Banking.service;

import com.example.Banking.dao.UserDao;
import com.example.Banking.exception.IdNotFoundException;
import com.example.Banking.model.Account;
import com.example.Banking.model.UserTransaction;
import org.springframework.beans.factory.annotation.Autowired;


@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private UserDao userDao;


    public String transaction(UserTransaction sender) throws Exception {
        Account senderAcc = userDao.getAccount(sender.getFromAccount()).orElseThrow(() -> new IdNotFoundException("Sender Account is not found"));
        Account recieverAcc = userDao.getAccountByAccountNumber(sender.getToAccount());

        if( senderAcc.getAccountNumber() == sender.getFromAccount() )
        { if( senderAcc.getBalance() > sender.getTransferAmount()) {
            userDao.updateBalance(sender.getTransferAmount(), senderAcc);

        }
        else { return new TransactionStatus().returnMsg("Transaction Failed due to insufficient balance"); }
            userDao.updateReceiverBalance(sender.getTransferAmount(), recieverAcc);
            userDao.insertTransactionTable(sender);
        }
        else { throw new IdNotFoundException("Sender Account is not available"); }
        return new TransactionStatus().returnMsg("Transaction Success");
    }
}
