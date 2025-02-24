package model;

import java.util.List;

public class Bank {


    private String bankName;
    private List<Branch> branches;
    private String address;

    public Bank(String bankName, List<Branch> branches, String Address) {
        this.bankName = bankName;
        this.branches = branches;
        this.address = Address;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        address = address;
    }

}