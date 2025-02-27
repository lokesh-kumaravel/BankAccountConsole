import model.*;
import view.TransactionHistoryview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.CustomerController;
import controller.TransactionController;

public class Main {

    static CustomerController customerController = new CustomerController();
    static TransactionController transactionController = new TransactionController();
    static TransactionHistoryview transactionHistory = new TransactionHistoryview();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Branch> branchList = new ArrayList<>();

        ArrayList<Customer> customerList = new ArrayList<>();
        Branch Udumalpet = new Branch(1, "SubBranch", "1234", "Coimbatore", customerList);
        branchList.add(Udumalpet);

        Bank kvbMain = new Bank("KVB", branchList, "Delhi");

        while (true) {
            System.out.println("\n===== Banking System Menu =====");
            System.out.println("1. Create New Customer");
            System.out.println("2. Add Account to Existing Customer");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. View Balance");
            System.out.println("6. View Customer Details");
            System.out.println("7. Transfer Money");
            System.out.println("8. View Transaction History");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            int choice = in.nextInt();
            in.nextLine();

            switch (choice) {
                case 1:
                    createNewCustomer(in, Udumalpet);
                    break;
                case 2:
                    addAccountToCustomer(in, Udumalpet);
                    break;
                case 3:
                    performTransaction(in, Udumalpet, true);
                    break;
                case 4:
                    performTransaction(in, Udumalpet, false);
                    break;
                case 5:
                    viewBalance(in, Udumalpet);
                    break;
                case 6:
                    viewCustomerDetails(Udumalpet);
                    break;
                case 7:
                    transferMoney(in, Udumalpet);
                    break;
                case 8:
                    transactionHistory.printHistory();
                    break;
                case 9:
                    System.out.println("Exiting system. Thank you!");
                    in.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please select again.");
            }
        }
    }

    private static void createNewCustomer(Scanner in, Branch branch) {
        customerController.createNewCustomer(in, branch);
    }

    private static void addAccountToCustomer(Scanner in, Branch branch) {
        System.out.print("Enter Customer ID to add an account: ");
        int customerId = in.nextInt();
        in.nextLine();
        customerController.addAccount(customerId, in, branch);
    }

    private static void performTransaction(Scanner in, Branch branch, boolean isDeposit) {
        transactionController.performTransaction(in, branch, isDeposit);
    }

    private static void viewBalance(Scanner in, Branch branch) {
        transactionController.viewBalance(in, branch);
    }

    private static void transferMoney(Scanner in, Branch branch) {
        TransactionController.transferMoney(in, branch);
    }

    private static void viewCustomerDetails(Branch branch) {
        System.out.println("\n==== Customer Details ====");
        for (Customer customer : branch.getCustomers()) {
            customer.displayCustomerDetails();
        }
    }
}