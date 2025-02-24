package model;

public interface Transaction {
    void transfer(double amount, Account targetAccount);
    void printTransactionHistory();
}