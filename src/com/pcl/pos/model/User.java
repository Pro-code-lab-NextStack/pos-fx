package com.pcl.pos.model;

public class User {
  private  String id;
  private  String userName;
  private   String password;
  private   String email;
  private  String contactNumber;
  private String userRole;

    public User(String id, String userName, String password, String email, String contactNumber,String role) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.contactNumber = contactNumber;
        this.userRole=role;
    }

    public User() {
    }

    public void setUserRole(String userRole){
        this.userRole=userRole;
    }
    public void setId(String id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public String getId() {
        return id;
    }

    public String getUserRole(){
        return userRole;
    }

}
