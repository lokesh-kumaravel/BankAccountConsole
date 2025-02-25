package model;

public interface Account {
    int getAccountNo();
    double getBalance();
    String getAccountType();

    void deposit(double amount);
    boolean withdraw(double amount);

}