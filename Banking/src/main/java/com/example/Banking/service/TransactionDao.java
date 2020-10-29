package com.example.Banking.service;

import com.example.Banking.model.Transaction;


public interface TransactionDao {

    /**
     * The insertTransactionTable() will record the time, date,state of transaction
     * at the initialize of transaction process.
     *
     * @param transactionDetails contains the id, fromAccount, toAccount and transferAmount
     */
    void insertTransactionTable(Transaction transactionDetails);


    /**
     * The updateTransactionTable() update the state of transaction as SUCCESS/FAILURE accoring
     * to the transaction
     *
     * @param transactionDetails contains the id, fromAccount, toAccount and transferAmount to find
     *                           the trnsaction status
     * @param state              has the state of transaction as SUCCESS/FAILURE
     */
    void updateTransactionTable(Transaction transactionDetails, Transaction.State state);
}
