package com.example.Banking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private long fromAccount;
    private long toAccount;
    private long transferAmount;

    @Enumerated(EnumType.STRING)
    private State state = State.STARTED;

    public enum State {
        STARTED, FAILED, SUCCESSFUL
    }

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
}

