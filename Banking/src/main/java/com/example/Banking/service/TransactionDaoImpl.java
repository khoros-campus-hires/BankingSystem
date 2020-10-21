package com.example.Banking.dao;

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
    public void insertTransactionTable(UserTransaction sender) {
        transactionRepository.save(sender);
    }

    @Override
    public void updateTransactionTable(Transaction sender, Transaction.State state) {
        sender.setState(state);
        transactionRepository.save(sender);
    }
}