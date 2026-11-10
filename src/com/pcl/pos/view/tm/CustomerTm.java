package com.pcl.pos.view.tm;

import javafx.scene.control.Button;

public class CustomerTm {
    private String id;
    private String name;
    private String email;
    private String salary;
    private String contact;
    private String address;
    private Button btn;

    public CustomerTm() {
    }

    public CustomerTm(String id, String name, String email, String salary, String contact, String address, Button btn) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.contact = contact;
        this.address = address;
        this.btn = btn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
