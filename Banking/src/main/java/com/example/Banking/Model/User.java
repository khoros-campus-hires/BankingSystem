package com.example.Banking.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "Users")
public class User {
        private long id;
        private long balance;


        public User() {}

        public User(long balance) {
            this.balance= balance;
        }

        @Id
        //@GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id", nullable=false)
        public long getId() {
            return id;
        }
        public void setId(long id) {
            this.id = id;
        }

        @Column(name = "balance", nullable = false)
        public long getBalance() { return balance; }
        public long setBalance(long balance) { return this.balance = balance;}

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", balance=" + balance +
                '}';
    }


}

