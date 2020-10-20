package com.example.Banking.repository;

import com.example.Banking.model.UserTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository <UserTransaction, Integer> {

}
