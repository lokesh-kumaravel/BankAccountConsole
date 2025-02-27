package DaoImpl;

import DAO.AccountDao;
import DAO.TransactionDao;
import view.TransactionHistoryview;

public class LoanAccount implements AccountDao, TransactionDao {
    private int accountNo;
    private double balance;
    private final String accountType = "Loan";
    private TransactionHistoryview transactionHistory = new TransactionHistoryview();

    public LoanAccount(int accountNo, double loanAmount) {
        this.accountNo = accountNo;
        this.balance = -loanAmount;
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
            transactionHistory.addTransaction("Loan Repayment: " + amount + " | Remaining Loan: " + balance);
            System.out.println("Loan Repayment: " + amount + " | Remaining Loan: " + balance);
        } else {
            System.out.println("Invalid repayment amount!");
        }
    }

    @Override
    public boolean withdraw(double amount) {

        System.out.println("Withdrawals are not allowed from a loan account.");
        return false;

    }

    @Override
    public void transfer(double amount, AccountDao targetAccount) {
        System.out.println("Transfers are not allowed from a loan account.");
    }

    @Override
    public void printTransactionHistory() {
        TransactionHistoryview.printHistory();
    }
}
