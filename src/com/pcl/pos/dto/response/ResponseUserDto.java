package com.pcl.pos.dto.response;

public class ResponseUserDto {
    private String email;
    private String userName;
    private int code;
    private String message;

    public ResponseUserDto() {
    }

    public ResponseUserDto(String email, String userName, int code, String message) {
        this.email = email;
        this.userName = userName;
        this.code = code;
        this.message = message;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
