package com.sauce.demo.entity;


//delete after maybe
public enum Roles {
    SIMPLE_USER("SIMPLE_USER"),
    ADMIN_USER("ADMIN_USER");

    private String userType;

    Roles(String userType) {
        this.userType = userType;
    }
}
