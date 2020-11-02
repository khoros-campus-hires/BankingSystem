package com.example.Banking.service;

import com.example.Banking.model.Account;
import com.example.Banking.model.Transaction;
import com.example.Banking.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class TransactionService {

    @Autowired
    private TransactionDao transactionDao;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountDao accountDao;


    public String transaction(Transaction transaction_details) throws Exception {
        transactionDao.insertTransactionTable(transaction_details);
        Account senderAccCheck = null;
        try {
            senderAccCheck = accountDao.getAccount(transaction_details.getFromAccount());
        } catch (Exception e) {
            transactionDao.updateTransactionTable(transaction_details, Transaction.State.FAILED);
        }
        Account senderAcc = accountDao.getAccount(transaction_details.getFromAccount());

        Account receiverAccCheck = null;
        try {
            receiverAccCheck = accountDao.getAccount(transaction_details.getToAccount());
        } catch (Exception e) {
            transactionDao.updateTransactionTable(transaction_details, Transaction.State.FAILED);
        }
        Account receiverAcc = accountDao.getAccount(transaction_details.getToAccount());

        if ((senderAcc.getAccountBalance() > transaction_details.getTransferAmount())) {
            long senderBalance = senderAcc.getAccountBalance() - transaction_details.getTransferAmount();
            long receiverBalance = receiverAcc.getAccountBalance() + transaction_details.getTransferAmount();
            accountRepository.updateBalance(senderBalance, senderAcc.getAccountNumber(), receiverBalance, receiverAcc.getAccountNumber());
            transactionDao.updateTransactionTable(transaction_details, Transaction.State.SUCCESSFUL);
            return new TransactionStatus().returnMsg("Transaction Success");
        } else {
            transactionDao.updateTransactionTable(transaction_details, Transaction.State.FAILED);
            return new TransactionStatus().returnMsg("Transaction Failed due to insufficient balance");
        }
    }
}