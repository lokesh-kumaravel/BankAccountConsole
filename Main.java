import model.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Account savings = new SavingAccount(5001, 10000);
        Account current = new CurrentAccount(5002, 20000);
        List<Account> accountList = new ArrayList<>();
        accountList.add(savings);
        accountList.add(current);

        Customer customer1 = new Customer(1001, "Lokesh K", "Coimbatore", "9345305756", accountList);
        ArrayList<Customer> customerList = new ArrayList<>();
        customerList.add(customer1);

        Branch Udumalpet = new Branch(1, "SubBranch", "1234", "Coimbatore", customerList);
        ArrayList<Branch> branchList = new ArrayList<>();
        branchList.add(Udumalpet);

        Bank kvbMain = new Bank("KVB", branchList, "Delhi");

        System.out.println("Bank Details:");
        System.out.println("Name: " + kvbMain.getBankName());
        System.out.println("Headquarters: " + kvbMain.getAddress());
        System.out.println("Total Branches: " + kvbMain.getBranches().size());

        for (Branch branch : kvbMain.getBranches()) {
            System.out.println("\nBranch Details:");
            System.out.println("Branch ID: " + branch.getBranchId());
            System.out.println("Branch Name: " + branch.getBranchName());
            System.out.println("IFSC Code: " + branch.getIfscCode());
            // System.out.println("Location: " + branch.getLocation());
            System.out.println("Total Customers: " + branch.getCustomers().size());

            for (Customer customer : branch.getCustomers()) {
                System.out.println("\nCustomer Details:");
                customer.displayCustomerDetails();

                if (!customer.getAccounts().isEmpty()) {
                    Account firstAccount = customer.getAccounts().get(0);
                    System.out.println("\nPerforming Transactions on Account No: " + firstAccount.getAccountNo());

                    // Deposit
                    firstAccount.deposit(5000);
                    System.out.println("Deposited 5000. New Balance: " + firstAccount.getBalance());

                    // Withdraw
                    firstAccount.withdraw(3000);
                    System.out.println("Withdrawn 3000. New Balance: " + firstAccount.getBalance());
                }
            }
        }
    }
}