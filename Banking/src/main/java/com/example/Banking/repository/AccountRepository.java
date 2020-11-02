package com.example.Banking.repository;

import com.example.Banking.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {


    @Query(value = "UPDATE account_details\n" +
            "   SET account_balance = CASE account_number \n" +
            "                      WHEN ?2 THEN ?1 \n" +
            "                      WHEN ?4 THEN ?3 \n" +
            "                      ELSE account_balance\n" +
            "                      END\n" +
            " WHERE account_number IN(?2, ?4)", nativeQuery = true)
    void updateBalance(long senderBalance, long senderAccountNumber, long receiverBalance, long receiverAccountNumber);

}
