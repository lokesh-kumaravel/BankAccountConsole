package DaoImpl;

import java.util.List;
import java.util.Scanner;

import DAO.CustomerDao;
import model.Branch;
import model.Customer;

public class Customerimpl implements CustomerDao {

    @Override
    public void createCustomer(Customer customer, Branch branch) {
        branch.getCustomers().add(customer);
        System.out.println("New customer added successfully!");
    }

    @Override
    public void addAccountToCustomer(int customerId, Scanner in, Branch branch) {
        for (Customer customer : branch.getCustomers()) {
            if (customer.getCustomerId() == customerId) {
                AccountDAOImpl accountDao = new AccountDAOImpl();
                accountDao.addAccount(in, customer.getAccounts());
                System.out.println("New account added for customer ID: " + customerId);
                return;
            }
        }
        System.out.println("Customer not found!");
    }

    @Override
    public Customer getCustomerById(int customerId) {
        return null;
    }

    @Override
    public void updateCustomer(Customer customer) {
    }

    @Override
    public void deleteCustomer(int customerId) {
    }

    @Override
    public List<Customer> getAllCustomers() {
        return null;
    }

}
