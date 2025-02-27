package DAO;

public interface AccountDao {

    int getAccountNo();

    double getBalance();

    String getAccountType();

    void deposit(double amount);

    boolean withdraw(double amount);

    void transfer(double amount, AccountDao recipientAccount);

}