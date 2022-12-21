package com.sauce.demo.entity;


//delete after maybe


public enum Page {

    FORGOT_PASSWORD("Forgot Password"),
    SIGN_UP("Sign Up"),
    MY_PROFILE("My Profile"),
    USER_ADMIN("User Admin");

    private String pageType;

    Page(String pageType) {
        this.pageType = pageType;
    }
}
