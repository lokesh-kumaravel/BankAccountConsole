package DaoImpl;

import DAO.AccountDao;
import DAO.TransactionDao;
import view.TransactionHistoryview;

public class CurrentAccount implements AccountDao, TransactionDao {
    private int accountNo;
    private double balance;
    private final String accountType = "Current";
    private TransactionHistoryview transactionHistory = new TransactionHistoryview();

    public CurrentAccount(int accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    @Override
    public int getAccountNo() {
        return accountNo;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public String getAccountType() {
        return accountType;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.addTransaction("Deposited: " + amount + " | New Balance: " + balance);
            System.out.println("Deposited: " + amount + " | New Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            transactionHistory.addTransaction("Withdrawn: " + amount + " | New Balance: " + balance);
            System.out.println("Withdrawn: " + amount + " | New Balance: " + balance);
            return true;
        } else {
            System.out.println("Insufficient balance or invalid amount!");
            return false;
        }
    }

    @Override
    public void transfer(double amount, AccountDao targetAccount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            targetAccount.deposit(amount);
            transactionHistory
                    .addTransaction("Transferred: " + amount + " to Account No: " + targetAccount.getAccountNo());
            System.out.println("Transferred: " + amount + " to Account No: " + targetAccount.getAccountNo());
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }

    @Override
    public void printTransactionHistory() {
        transactionHistory.printHistory();
    }

}
