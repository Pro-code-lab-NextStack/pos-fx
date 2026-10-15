package com.pcl.pos.dto.response;

public class ResponseRolesDto {
    private String id;
    private String role;
    private int code;
    private String message;

    public ResponseRolesDto() {
    }

    public ResponseRolesDto(String id, String role, int code, String message) {
        this.id = id;
        this.role = role;
        this.code = code;
        this.message = message;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
