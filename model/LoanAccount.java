package model;

public class LoanAccount implements Account, Transaction {
    private int accountNo;
    private double balance;
    private final String accountType = "Loan";
    private TransactionHistory transactionHistory = new TransactionHistory();

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
    public void withdraw(double amount) {
        System.out.println("Withdrawals are not allowed from a loan account.");
    }

    @Override
    public void transfer(double amount, Account targetAccount) {
        System.out.println("Transfers are not allowed from a loan account.");
    }

    @Override
    public void printTransactionHistory() {
        transactionHistory.printHistory();
    }
}
