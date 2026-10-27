package com.pcl.pos.view.tm;

import javafx.scene.control.Button;

public class UserTm {
    private String id;
    private String userName;
    private String email;
    private String role;
    private Button btn;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    public UserTm() {
    }

    public UserTm(String id, String userName, String email, String role, Button btn) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.role = role;
        this.btn = btn;
    }
}
