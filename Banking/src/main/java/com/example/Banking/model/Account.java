package com.example.Banking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "accountdetails")
public class Account {

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

    @Column(name = "AccountNumber",nullable = false)
    public long getAccountNumber()
    {
        return AccountNumber;
    }
    public void setAccountNumber(long accountNumber)
    {
        AccountNumber = accountNumber;
    }

    @Column(name = "AccountType",nullable = false)
    public String getAccountType()
    {
        return AccountType;
    }
    public void setAccountType(String accountType)
    {
        AccountType = accountType;
    }

    @Column(name = "BankName",nullable = false)
    public String getBankName()
    {
        return BankName;
    }
    public void setBankName(String bankName) {
        BankName = bankName;
    }

    @Column(name = "BranchName",nullable = false)
    public String getBranchName() {
        return BranchName;
    }

    public void setBranchName(String branchName)

    {
        BranchName = branchName;
    }

    @Column(name = "AccountBalance",nullable = false)
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
