package model;

import java.util.List;

public class Branch {

    private int branchId;
    private String branchName;
    public String ifsc_code;
    public String address;
    private List<Customer> customers;

    public Branch(int branchId, String branchName, String ifsc_code, String address, List<Customer> customers) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.ifsc_code = ifsc_code;
        this.address = address;
        this.customers = customers;
    }
    public String getIfscCode() {
        return ifsc_code;
    }

    public void setIfsc_code(String ifsc_code) {
        this.ifsc_code = ifsc_code;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

}
