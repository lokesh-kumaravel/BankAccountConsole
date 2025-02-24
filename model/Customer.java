package model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int customerId;
    private String name;
    private String address;
    private String phoneNo;
    private List<Account> accounts;

    public Customer(int customerId, String name, String address, String phoneNo, List<Account> accounts) {
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

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }

    public void displayCustomerDetails() {
        System.out.println("Customer ID: " + customerId);
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Phone No: " + phoneNo);
        System.out.println("Accounts:");
        for (Account acc : accounts) {
            System.out.println("  - " + acc.getAccountType() + " (Acc No: " + acc.getAccountNo() + ")");
        }
    }
}
