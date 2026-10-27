package com.pcl.pos.dto.response;

public class ResponseUserDto {
    private String email;
    private String userName;
    private String userId;
    private String roleName;
    private int code;
    private String message;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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

    public String getUserId() {
        return userId;
    }

    public String getRoleName() {
        return roleName;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public ResponseUserDto() {
    }

    public ResponseUserDto(String email, String userName, String userId, String roleName, int code, String message) {
        this.email = email;
        this.userName = userName;
        this.userId = userId;
        this.roleName = roleName;
        this.code = code;
        this.message = message;
    }
}
