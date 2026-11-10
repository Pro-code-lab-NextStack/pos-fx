package com.pcl.pos.dto.request;

public class CustomerRequestDto {
   private String name;
   private double salary;
   private String contact;
   private String address;
   private String email;

    public CustomerRequestDto() {
    }

    public CustomerRequestDto(String name, double salary, String contact, String address, String email) {
        this.name = name;
        this.salary = salary;
        this.contact = contact;
        this.address = address;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
