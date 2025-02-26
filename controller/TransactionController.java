package controller;

import java.util.Scanner;

import DAO.AccountDao;
import model.Branch;
import model.Customer;

public class TransactionController {

    public void performTransaction(Scanner in, Branch branch, boolean isDeposit) {
        System.out.print("Enter Customer ID: ");
        int customerId = in.nextInt();
        System.out.print("Enter Account Number: ");
        int accNo = in.nextInt();
        System.out.print("Enter Amount: ");
        double amount = in.nextDouble();

        for (Customer customer : branch.getCustomers()) {
            if (customer.getCustomerId() == customerId) {
                for (AccountDao account : customer.getAccounts()) {
                    if (account.getAccountNo() == accNo) {
                        if (isDeposit) {
                            account.deposit(amount);
                            System.out.println("Deposited " + amount + ". New Balance: " + account.getBalance());
                        } else {
                            if (account.withdraw(amount)) {
                                System.out.println("Withdrawn " + amount + ". New Balance: " + account.getBalance());
                            } else {
                                System.out.println("Insufficient balance!");
                            }
                        }
                        return;
                    }
                }
            }
        }
        System.out.println("Account not found!");
    }

    public static void transferMoney(Scanner in, Branch branch) {

        System.out.print("Enter Sender's Customer ID: ");
        int senderId = in.nextInt();
        System.out.print("Enter Sender's Account Number: ");
        int senderAccNo = in.nextInt();

        System.out.print("Enter Recipient's Customer ID: ");
        int recipientId = in.nextInt();
        System.out.print("Enter Recipient's Account Number: ");
        int recipientAccNo = in.nextInt();

        System.out.print("Enter Amount to Transfer: ");
        double amount = in.nextDouble();

        AccountDao senderAccount = null;
        AccountDao recipientAccount = null;

        for (Customer customer : branch.getCustomers()) {
            if (customer.getCustomerId() == senderId) {
                for (AccountDao account : customer.getAccounts()) {
                    if (account.getAccountNo() == senderAccNo) {
                        senderAccount = account;
                    }
                }
            }
            if (customer.getCustomerId() == recipientId) {
                for (AccountDao account : customer.getAccounts()) {
                    if (account.getAccountNo() == recipientAccNo) {
                        recipientAccount = account;
                    }
                }
            }
        }

        if (senderAccount == null || recipientAccount == null) {
            System.out.println("Error: One or both accounts not found.");
            return;
        }

        senderAccount.transfer(amount, recipientAccount);
    }

    public void viewBalance(Scanner in, Branch branch) {
        System.out.print("Enter Customer ID: ");
        int customerId = in.nextInt();

        System.out.print("Enter Account Number: ");
        int accountNo = in.nextInt();

        AccountDao foundAccount = null;

        for (Customer customer : branch.getCustomers()) {
            if (customer.getCustomerId() == customerId) {
                for (AccountDao account : customer.getAccounts()) {
                    if (account.getAccountNo() == accountNo) {
                        foundAccount = account;
                        break;
                    }
                }
            }
        }

        if (foundAccount != null) {
            System.out.println("Account Balance: $" + foundAccount.getBalance());
        } else {
            System.out.println("Error: Account not found.");
        }
    }

}
