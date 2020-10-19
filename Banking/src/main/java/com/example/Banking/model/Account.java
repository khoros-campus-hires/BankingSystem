package com.example.Banking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "account_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account
{

    @Id
    @GeneratedValue
    private long id;
    private long AccountNumber;
    private String AccountType;
    private String BankName;
    private String BranchName;
    private long AccountBalance;
    private String IfscCode;
    private long CifNumber;
    private long InitialPayment;


}
