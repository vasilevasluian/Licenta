package com.sauce.demo.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

//delete

@Setter
@Getter
@Builder
public class User {

    private String fullName;
    private String username;
    private String password;
    private String emailUsername;
    private String emailPassword;
    private boolean isAvailable;
    private String id;
    private String type;
}
