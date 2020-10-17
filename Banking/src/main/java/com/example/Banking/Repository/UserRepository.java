package com.example.Banking.Repository;

import com.example.Banking.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM users WHERE account_number = ?1",nativeQuery = true)
    public User findByAccNo ( long receiverAccNo);
}
