package com.picpay.picpaydemo.domain.user;

public enum UserRole {
    COMMON("common"),
    MERCHANT("merchant"),
    ADMIN("admin");

    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
