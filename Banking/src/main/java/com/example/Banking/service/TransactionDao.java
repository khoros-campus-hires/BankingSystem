package com.example.Banking.dao;

import com.example.Banking.model.Transaction;


public interface TransactionDao {

    public void insertTransactionTable(UserTransaction sender);
    public void updateTransactionTable(Transaction sender, Transaction.State state);
}
