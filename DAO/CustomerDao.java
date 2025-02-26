package DAO;

import java.util.List;
import java.util.Scanner;

import model.Branch;
import model.Customer;

public interface CustomerDao {
    void addAccountToCustomer(int customerId, Scanner in, Branch branch);

    void createCustomer(Customer customer, Branch branch);

    Customer getCustomerById(int customerId);

    void updateCustomer(Customer customer);

    void deleteCustomer(int customerId);

    List<Customer> getAllCustomers();

}