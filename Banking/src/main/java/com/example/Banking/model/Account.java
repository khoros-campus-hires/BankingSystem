package com.example.Banking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "accountdetails")
public class Account {

    private int id;
    private long AccountNumber;
    private String AccountType;
    private String BankName;
    private String BranchName;
    private long AccountBalance;

    public Account() {
    }

    public Account(long accountNumber, String accountType, String bankName, String branchName, long accountBalance) {
        AccountNumber = accountNumber;
        AccountType = accountType;
        BankName = bankName;
        BranchName = branchName;
        AccountBalance = accountBalance;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    @Column(name = "Account_Number",nullable = false)
    public long getAccountNumber()
    {
        return AccountNumber;
    }
    public void setAccountNumber(long accountNumber)
    {
        AccountNumber = accountNumber;
    }

    @Column(name = "Account_Type",nullable = false)
    public String getAccountType()
    {
        return AccountType;
    }
    public void setAccountType(String accountType)
    {
        AccountType = accountType;
    }

    @Column(name = "Bank_Name",nullable = false)
    public String getBankName()
    {
        return BankName;
    }
    public void setBankName(String bankName) {
        BankName = bankName;
    }

    @Column(name = "Branch_Name",nullable = false)
    public String getBranchName() {
        return BranchName;
    }

    public void setBranchName(String branchName)

    {
        BranchName = branchName;
    }

    @Column(name = "Account_Balance",nullable = false)
    public long getAccountBalance()
    {
        return AccountBalance;
    }
    public void setAccountBalance(long accountBalance)
    {
        AccountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "AccountNumber=" + AccountNumber +
                ", AccountType='" + AccountType + '\'' +
                ", BankName='" + BankName + '\'' +
                ", BranchName='" + BranchName + '\'' +
                ", AccountBalance=" + AccountBalance +
                '}';
    }
}
