package DAO;

import java.util.Scanner;

import model.Branch;

public interface AccountDao {

    int getAccountNo();

    double getBalance();

    String getAccountType();

    void deposit(double amount);

    boolean withdraw(double amount);

    void transfer(double amount, AccountDao recipientAccount);

}