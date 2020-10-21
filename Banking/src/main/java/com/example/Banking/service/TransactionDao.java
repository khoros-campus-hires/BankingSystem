package com.example.Banking.service;

import com.example.Banking.model.Transaction;


public interface TransactionDao {

    public void insertTransactionTable(Transaction transaction_details);
    public void updateTransactionTable(Transaction transaction_details, Transaction.State state);
}
