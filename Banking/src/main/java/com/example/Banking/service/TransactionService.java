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


    public String transaction(Transaction transaction_details) throws Exception {
        transactionDao.insertTransactionTable(transaction_details);
        Account senderAccCheck = null;
        try{ senderAccCheck = accountDao.getAccount(transaction_details.getFromAccount()); }
        catch (Exception e) { transactionDao.updateTransactionTable(transaction_details,Transaction.State.FAILED); }
        Account senderAcc = accountDao.getAccount(transaction_details.getFromAccount());

        Account receiverAccCheck = null;
        try{ receiverAccCheck = accountDao.getAccount(transaction_details.getToAccount());}
        catch (Exception e){ transactionDao.updateTransactionTable(transaction_details,Transaction.State.FAILED);}
        Account receiverAcc = accountDao.getAccount(transaction_details.getToAccount());

        if( (senderAcc.getAccountBalance() > transaction_details.getTransferAmount()) ) {

            senderAcc.setAccountBalance(senderAcc.getAccountBalance() - transaction_details.getTransferAmount());
            accountDao.updateAccount(senderAcc);
            receiverAcc.setAccountBalance(receiverAcc.getAccountBalance() + transaction_details.getTransferAmount());
            accountDao.updateAccount(receiverAcc);
            transactionDao.updateTransactionTable(transaction_details,Transaction.State.SUCCESSFUL);


            return new TransactionStatus().returnMsg("Transaction Success");
        }
        else {
            transactionDao.updateTransactionTable(transaction_details,Transaction.State.FAILED);
            return new TransactionStatus().returnMsg("Transaction Failed due to insufficient balance");
        }


    }
}
