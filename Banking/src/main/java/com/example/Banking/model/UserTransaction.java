package com.example.Banking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transaction")
public class UserTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private long fromAccount;
    private long toAccount;
    private long transferAmount;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
}

