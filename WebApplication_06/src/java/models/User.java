/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author tungi
 */
public class User {
    private String userID;
    private String fullName;
    private String address;
    private String phone;
    private String taxId;
    // ... 

    public User() {
    }

    public User(String userID, String fullName, String address, String phone, String taxId) {
        this.userID = userID;
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.taxId = taxId;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }
    
}
