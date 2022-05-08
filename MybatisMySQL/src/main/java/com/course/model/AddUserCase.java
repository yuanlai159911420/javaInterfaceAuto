package com.course.model;

import lombok.Data;

@Data
public class AddUserCase {
    private String username;
    private String password;
    private String sex;
    private int age;
    private String permission;
    private String isDelete;
    private String expected;

    @Override
    public String toString() {
        return "{"
                + "username: " + this.username + ", "
                + "password: " + this.password + ", "
                + "sex: " + this.sex + ", "
                + "age: " + this.age + ", "
                + "permission: " + this.permission + ", "
                + "isDelete: " + this.isDelete + ", "
                + "expected: " + this.expected
                + "}";
    }
}
