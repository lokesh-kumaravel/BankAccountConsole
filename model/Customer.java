package model;

import java.util.ArrayList;
import java.util.List;

import DAO.AccountDao;

public class Customer {
    private int customerId;
    private String name;
    private String address;
    private String phoneNo;
    private List<AccountDao> accounts;

    public Customer(int customerId, String name, String address, String phoneNo, List<AccountDao> accounts) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        setPhoneNo(phoneNo);
        this.accounts = new ArrayList<>();
        this.accounts = accounts;
    }

    public Customer(int customerId, String name, String address, String phoneNo) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        setPhoneNo(phoneNo);
        this.accounts = new ArrayList<>();
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        if (phoneNo.matches("\\d{10}")) {
            this.phoneNo = phoneNo;
        } else {
            throw new IllegalArgumentException("Invalid phone number! Must be 10 digits.");
        }
    }

    public void addAccount(AccountDao account) {
        accounts.add(account);
    }

    public List<AccountDao> getAccounts() {
        return accounts;
    }

    public void removeAccount(AccountDao account) {
        accounts.remove(account);
    }

    public void displayCustomerDetails() {
        System.out.println("Customer ID: " + customerId);
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Phone No: " + phoneNo);
        System.out.println("Accounts:");
        for (AccountDao acc : accounts) {
            System.out.println("  - " + acc.getAccountType() + " (Acc No: " + acc.getAccountNo() + ")");
        }
    }
}
