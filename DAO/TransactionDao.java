package DAO;

public interface TransactionDao {
    void transfer(double amount, AccountDao targetAccount);

    void printTransactionHistory();
}