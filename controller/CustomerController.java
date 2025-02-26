package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DAO.AccountDao;
import DaoImpl.Customerimpl;
import model.Branch;
import model.Customer;

public class CustomerController {
    private Customerimpl customerimpl = new Customerimpl();

    public void createNewCustomer(Scanner in, Branch branch) {
        System.out.print("Enter Customer ID: ");
        int customerId = in.nextInt();
        in.nextLine();
        System.out.print("Enter Name: ");
        String name = in.nextLine();
        System.out.print("Enter Address: ");
        String address = in.nextLine();
        System.out.print("Enter Phone Number: ");
        String phoneNo = in.nextLine();

        List<AccountDao> accounts = new ArrayList<>();

        Customer newCustomer = new Customer(customerId, name, address, phoneNo, accounts);
        customerimpl.createCustomer(newCustomer, branch);
        System.out.println("New customer created successfully!");
    }

    public void addAccount(int customerId, Scanner in, Branch branch) {
        customerimpl.addAccountToCustomer(customerId, in, branch);
    }
}
