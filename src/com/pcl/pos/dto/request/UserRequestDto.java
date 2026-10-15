package com.pcl.pos.dto.request;

public class UserRequestDto {
    private String userName;
    private String email;
    private String rowPw;
    private String contact;
    private String roleId;

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleId() {
        return roleId;
    }

    public UserRequestDto() {
    }

    public UserRequestDto(String userName, String email, String rowPw, String contact,String roleId) {
        this.userName = userName;
        this.email = email;
        this.rowPw = rowPw;
        this.contact = contact;
        this.roleId=roleId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRowPw(String rowPw) {
        this.rowPw = rowPw;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getRowPw() {
        return rowPw;
    }

    public String getContact() {
        return contact;
    }
}
