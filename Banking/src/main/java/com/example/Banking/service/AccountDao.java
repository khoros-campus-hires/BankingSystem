package com.example.Banking.service;

import com.example.Banking.exception.IdNotFoundException;
import com.example.Banking.model.Account;

import java.util.List;


public interface AccountDao {


    /**
     * getAll() returns all the user from the database
     *
     * @return all the users
     */
    List<Account> getAll();


    /**
     * getAccount() return one user account details according to the AccountNumber
     *
     * @param acNumber account number of the user to be fetched
     * @return return the account details matched with the account number
     * @throws IdNotFoundException throws if account not found with given account number
     */
    Account getAccount(long acNumber) throws IdNotFoundException;

    /**
     * insertAccount() Creates new user account
     *
     * @param account carries attributes of Account class
     */
    void insertAccount(Account account);


    /**
     * deleteAccount() delete a particular account
     *
     * @param acNumber Account Number of the account to be deleted
     * @throws IdNotFoundException throws if account not found with given account number
     */
    void deleteAccount(long acNumber) throws IdNotFoundException;


    /**
     * updateAccount() to update the inf
     *
     * @param account carries attributes of Account class
     * @throws IdNotFoundException throws if account not found
     */
    void updateAccount(Account account) throws IdNotFoundException;

}
