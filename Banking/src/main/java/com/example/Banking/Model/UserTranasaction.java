package com.example.Banking.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserTranasaction {
    private long fromAccount;
    private long toAccount;
    private long transferAmount;
}
