package com.sauce.demo.entity;


//delete after maybe
public enum Roles {
    SIMPLE_USER("SIMPLE_USER"),
    PROBLEM_USER("PROBLEM_USER"),
    ADMIN_USER("ADMIN_USER");

    private String userType;

    Roles(String userType) {
        this.userType = userType;
    }
}
