package com.example.Banking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "accountdetails2")
public class Account {

    private long id;
    private long AccountNumber;
    private String AccountType;
    private String BankName;
    private String BranchName;
    private long AccountBalance;
    private String IfscCode;
    private long CifNumber;



    public Account() {
    }

    public Account(long id, long accountNumber, String accountType, String bankName, String branchName, long accountBalance, String ifscCode, long cifNumber) {
        this.id = id;
        AccountNumber = accountNumber;
        AccountType = accountType;
        BankName = bankName;
        BranchName = branchName;
        AccountBalance = accountBalance;
        IfscCode = ifscCode;
        CifNumber = cifNumber;
    }

    @Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_number",nullable = false)
    public long getAccountNumber()
    {
        return AccountNumber;
    }
    public void setAccountNumber(long accountNumber)
    {
        AccountNumber = accountNumber;
    }

    @Column(name = "account_type",nullable = false)
    public String getAccountType()
    {
        return AccountType;
    }
    public void setAccountType(String accountType)
    {
        AccountType = accountType;
    }

    @Column(name = "bank_name",nullable = false)
    public String getBankName()
    {
        return BankName;
    }
    public void setBankName(String bankName) {
        BankName = bankName;
    }

    @Column(name = "branch_name",nullable = false)
    public String getBranchName() {
        return BranchName;
    }

    public void setBranchName(String branchName)

    {
        BranchName = branchName;
    }

    @Column(name = "account_balance",nullable = false)
    public long getAccountBalance()
    {
        return AccountBalance;
    }
    public void setAccountBalance(long accountBalance)
    {
        AccountBalance = accountBalance;
    }

    @Column(name = "ifsc_code",nullable = false)
    public String getIfscCode() {
        return IfscCode;
    }
    public void setIfscCode(String ifscCode) {
        IfscCode = ifscCode;
    }

    @Column(name = "cif_number",nullable = false)
    public long getCifNumber() {
        return CifNumber;
    }

    public void setCifNumber(long cifNumber) {
        CifNumber = cifNumber;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", AccountNumber=" + AccountNumber +
                ", AccountType='" + AccountType + '\'' +
                ", BankName='" + BankName + '\'' +
                ", BranchName='" + BranchName + '\'' +
                ", AccountBalance=" + AccountBalance +
                ", IfscCode='" + IfscCode + '\'' +
                ", CifNumber=" + CifNumber +
                '}';
    }
}
