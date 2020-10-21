package com.example.Banking.model;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "account_details")
@Data
public class Account
{

    @Id
    private long accountNumber;
    private long id;
    private String accountType;
    private String bankName;
    private String branchName;
    private long accountBalance;
    private String ifscCode;
    private long cifNumber;


    


}
