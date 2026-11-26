package com.pcl.pos.dto.response;

public class VendorResponseDto {
    private String id;
    private String name;
    private String phone;
    private String address;
    private int Code;
    private String message;

    public VendorResponseDto() {
    }

    public VendorResponseDto(String id, String name, String phone, String address, int code, String message) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        Code = code;
        this.message = message;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
