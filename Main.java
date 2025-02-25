import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Branch> branchList = new ArrayList<>();

        // Creating a default branch
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
            System.out.println("5. View Customer Details");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createNewCustomer(scanner, Udumalpet);
                    break;
                case 2:
                    addAccountToCustomer(scanner, Udumalpet);
                    break;
                case 3:
                    performTransaction(scanner, Udumalpet, true); // true for deposit
                    break;
                case 4:
                    performTransaction(scanner, Udumalpet, false); // false for withdraw
                    break;
                case 5:
                    viewCustomerDetails(Udumalpet);
                    break;
                case 6:
                    System.out.println("Exiting system. Thank you!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please select again.");
            }
        }
    }

    private static void createNewCustomer(Scanner scanner, Branch branch) {
        System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        String phoneNo = scanner.nextLine();

        List<Account> accounts = new ArrayList<>();
        addAccount(scanner, accounts);

        Customer newCustomer = new Customer(customerId, name, address, phoneNo, accounts);
        branch.getCustomers().add(newCustomer);
        System.out.println("New customer created successfully!");
    }

    private static void addAccountToCustomer(Scanner scanner, Branch branch) {
        System.out.print("Enter Customer ID to add an account: ");
        int customerId = scanner.nextInt();
        scanner.nextLine();

        for (Customer customer : branch.getCustomers()) {
            if (customer.getCustomerId() == customerId) {
                addAccount(scanner, customer.getAccounts());
                System.out.println("New account added for customer ID: " + customerId);
                return;
            }
        }
        System.out.println("Customer not found!");
    }

    private static void addAccount(Scanner scanner, List<Account> accounts) {
        System.out.print("Enter Account Number: ");
        int accNo = scanner.nextInt();
        System.out.print("Enter Initial Balance: ");
        double balance = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter Account Type (Savings/Current/Loan): ");
        String accType = scanner.nextLine().trim().toLowerCase();

        Account newAccount;
        if (accType.equals("savings")) {
            newAccount = new SavingAccount(accNo, balance);
        } else if (accType.equals("current")) {
            newAccount = new CurrentAccount(accNo, balance);
        } else if (accType.equals("loan")) {
            newAccount = new LoanAccount(accNo, balance);
        } else {
            System.out.println("Invalid account type!");
            return;
        }

        accounts.add(newAccount);
        System.out.println("Account created successfully!");
    }

    private static void performTransaction(Scanner scanner, Branch branch, boolean isDeposit) {
        System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt();
        System.out.print("Enter Account Number: ");
        int accNo = scanner.nextInt();
        System.out.print("Enter Amount: ");
        double amount = scanner.nextDouble();

        for (Customer customer : branch.getCustomers()) {
            if (customer.getCustomerId() == customerId) {
                for (Account account : customer.getAccounts()) {
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

    private static void viewCustomerDetails(Branch branch) {
        System.out.println("\n==== Customer Details ====");
        for (Customer customer : branch.getCustomers()) {
            customer.displayCustomerDetails();
        }
    }
}




//import model.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Main {
//    public static void main(String[] args) {
//
//        Account savings = new SavingAccount(5001, 10000);
//        Account current = new CurrentAccount(5002, 20000);
//        List<Account> accountList = new ArrayList<>();
//        accountList.add(savings);
//        accountList.add(current);
//
//        Customer customer1 = new Customer(1001, "Lokesh K", "Coimbatore", "9345305756", accountList);
//        ArrayList<Customer> customerList = new ArrayList<>();
//        customerList.add(customer1);
//
//        Branch Udumalpet = new Branch(1, "SubBranch", "1234", "Coimbatore", customerList);
//        ArrayList<Branch> branchList = new ArrayList<>();
//        branchList.add(Udumalpet);
//
//        System.out.println("------------"+Udumalpet.getIfscCode());
//        Bank kvbMain = new Bank("KVB", branchList, "Delhi");
//
//        System.out.println("Bank Details:");
//        System.out.println("Name: " + kvbMain.getBankName());
//        System.out.println("Headquarters: " + kvbMain.getAddress());
//        System.out.println("Total Branches: " + kvbMain.getBranches().size());
//
//        for (Branch branch : kvbMain.getBranches()) {
//            System.out.println("\nBranch Details:");
//            System.out.println("Branch ID: " + branch.getBranchId());
//            System.out.println("Branch Name: " + branch.getBranchName());
//            System.out.println("IFSC Code: " + branch.getIfscCode());
//             System.out.println("Location: " + branch.getAddress());
//            System.out.println("Total Customers: " + branch.getCustomers().size());
//
//            for (Customer customer : branch.getCustomers()) {
//                System.out.println("\nCustomer Details:");
//                customer.displayCustomerDetails();
//
//                if (!customer.getAccounts().isEmpty()) {
//                    Account firstAccount = customer.getAccounts().get(0);
//                    System.out.println("\nPerforming Transactions on Account No: " + firstAccount.getAccountNo());
//
//                    // Deposit
//                    firstAccount.deposit(5000);
//                    System.out.println("Deposited 5000. New Balance: " + firstAccount.getBalance());
//
//                    // Withdraw
//                    firstAccount.withdraw(3000);
//                    System.out.println("Withdrawn 3000. New Balance: " + firstAccount.getBalance());
//                }
//            }
//        }
//    }
//}