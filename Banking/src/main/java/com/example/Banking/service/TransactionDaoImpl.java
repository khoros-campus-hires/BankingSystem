package com.example.Banking.service;

import com.example.Banking.model.Transaction;
import com.example.Banking.repository.TransactionRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TransactionDaoImpl  implements TransactionDao{


    @NonNull
    private TransactionRepository transactionRepository;

    @Override
    public void insertTransactionTable(Transaction transaction_details) {
        transactionRepository.save(transaction_details);
    }

    @Override
    public void updateTransactionTable(Transaction transaction_details, Transaction.State state) {
        transaction_details.setState(state);
        transactionRepository.save(transaction_details);
    }
}