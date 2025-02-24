package model;

public interface Account {
    int getAccountNo();
    double getBalance();
    String getAccountType();

    void deposit(double amount);
    void withdraw(double amount);

}