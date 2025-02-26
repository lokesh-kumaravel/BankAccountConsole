package DaoImpl;

import DAO.AccountDao;
import java.util.List;
import java.util.Scanner;

public class AccountDAOImpl {

    public void addAccount(Scanner in, List<AccountDao> accounts) {
        System.out.print("Enter Account Number: ");
        int accNo = in.nextInt();
        System.out.print("Enter Initial Balance: ");
        double balance = in.nextDouble();
        in.nextLine();

        System.out.print("Enter Account Type (Savings/Current/Loan): ");
        String accType = in.nextLine().trim().toLowerCase();

        AccountDao newAccount;
        switch (accType) {
            case "savings":
                newAccount = new SavingAccount(accNo, balance);
                break;
            case "current":
                newAccount = new CurrentAccount(accNo, balance);
                break;
            case "loan":
                newAccount = new LoanAccount(accNo, balance);
                break;
            default:
                System.out.println("Invalid account type!");
                return;
        }

        accounts.add(newAccount);
        System.out.println("Account created successfully!");
    }
}
