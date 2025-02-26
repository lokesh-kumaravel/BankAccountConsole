package model;

import java.util.ArrayList;
import java.util.List;

public class TransactionHistoryview {
    // private List<String> transactions = new ArrayList<>();
    private static List<String> transactions = new ArrayList<>();

    public void addTransaction(String record) {
        transactions.add(record);
    }

    public static void printHistory() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            System.out.println("Transaction History:");
            for (String record : transactions) {
                System.out.println(record);
            }
        }
    }

    public List<String> getTransactions() {
        return transactions;
    }
}
