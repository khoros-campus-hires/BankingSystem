package com.example.Banking.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "account_details")
@Data
public class Account {

    @Id
    private long id;
    private long AccountNumber;
    private String AccountType;
    private String BankName;
    private String BranchName;
    private long AccountBalance;
    private String IfscCode;
    private long CifNumber;
    private long InitialPayment;

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
                ", InitialPayment=" + InitialPayment +
                '}';
    }
}
