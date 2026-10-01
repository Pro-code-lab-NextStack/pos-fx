package com.pcl.pos.entity;

public class User {
    private String userId;
    private String userName;
    private String password;
    private String email;
    private String contactNumber;
    private String roleId;

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", roleId='" + roleId + '\'' +
                '}';
    }

    public User(String userId, String userName, String password, String email, String contactNumber, String roleId) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.contactNumber = contactNumber;
        this.roleId = roleId;
    }

    public User() {
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getRoleId() {
        return roleId;
    }
}
