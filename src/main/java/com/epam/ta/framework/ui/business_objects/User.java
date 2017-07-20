package com.epam.ta.framework.ui.business_objects;

public class User {
    private String login;
    private String password ;
    private String fullName;

    public User() {
        this.login = "dab";
        this.password = "1q2w3e4r5t";
        this.fullName = "Dina Abdykasheva";
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }
}
