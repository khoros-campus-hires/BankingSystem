package com.example.Banking.repository;

import com.example.Banking.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Account, Long> {

    @Query(value = "SELECT * FROM account WHERE account_number = ?1",nativeQuery = true)
    User findByAccNo ( long receiverAccNo);
}
