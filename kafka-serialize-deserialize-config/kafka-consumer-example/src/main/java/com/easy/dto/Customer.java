package com.easy.dto;

public class Customer {

    private int id;
    private String custName;
    private String emailId;
    private String contactNo;

    public int getId() {
        return id;
    }

    public String getCustName() {
        return custName;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", custName='" + custName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", contactNo='" + contactNo + '\'' +
                '}';
    }
}
