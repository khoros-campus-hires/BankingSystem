package com.example.Banking.service;

import com.example.Banking.model.Transaction;
import com.example.Banking.repository.TransactionRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TransactionDaoImpl implements TransactionDao {


    @NonNull
    private TransactionRepository transactionRepository;

    @Override
    public void insertTransactionTable(Transaction transactionDetails) {
        transactionRepository.save(transactionDetails);
    }

    @Override
    public void updateTransactionTable(Transaction transactionDetails, Transaction.State state) {
        transactionDetails.setState(state);
        transactionRepository.save(transactionDetails);
    }
}