package com.course.model;

import lombok.Data;

@Data
public class LoginCase {
    private int id;
    private String username;
    private String password;
    private String expected;

    @Override
    public String toString(){
        return "{"
                + "username: " + this.username + ", "
                + "password: " + this.password + ", "
                + "expected: " + this.expected
                + "}";
    }
}
