package com.sauce.demo.entity;


//delete after maybe
public enum Roles {
    SIMPLE_USER("SIMPLE_USER"),
    PROBLEM_USER("PROBLEM_USER"),
    PROBLEM_GLITCH_USER("PROBLEM_GLITCH_USER"),

    LOCKED_OUT_USER("LOCKED_OUT_USER"),

    WRONG_PASSWORD("WRONG_PASSWORD"),
    WRONG_USERNAME("WRONG_USERNAME");


    private String userType;

    Roles(String userType) {
        this.userType = userType;
    }
}
