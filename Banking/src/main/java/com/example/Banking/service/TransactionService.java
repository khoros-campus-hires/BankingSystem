package com.example.Banking.service;

import com.example.Banking.model.Account;
import com.example.Banking.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;


@org.springframework.stereotype.Service
public class TransactionService {

    @Autowired
    private TransactionDao transactionDao;
    @Autowired
    private AccountDao accountDao;


    public String transaction(Transaction sender) throws Exception {
        transactionDao.insertTransactionTable(sender);
        Account senderAcc = accountDao.getAccount(sender.getFromAccount());
        Account recieverAcc = accountDao.getAccount(sender.getToAccount());

        if( senderAcc.getAccountBalance() > sender.getTransferAmount()) {
            senderAcc.setAccountBalance(senderAcc.getAccountBalance() - sender.getTransferAmount());
            accountDao.updateAccount(senderAcc);
            transactionDao.updateTransactionTable(sender,Transaction.State.SUCCESSFUL);
        }

        else {
            transactionDao.updateTransactionTable(sender,Transaction.State.FAILED);
            return new TransactionStatus().returnMsg("Transaction Failed due to insufficient balance");
        }

        recieverAcc.setAccountBalance(recieverAcc.getAccountBalance() + sender.getTransferAmount());
        accountDao.updateAccount(recieverAcc);
        return new TransactionStatus().returnMsg("Transaction Success");
    }
}
