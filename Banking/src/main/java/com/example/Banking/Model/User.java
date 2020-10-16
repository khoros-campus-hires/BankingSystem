package com.example.Banking.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private long id;
    private long accountNumber;
    private long balance;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public long getBalance() {
        return balance;
    }

    public long setBalance(long balance) {
        this.balance = balance;
        return balance;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", accountNumber=" + accountNumber +
                ", balance=" + balance +
                '}';
    }

}

