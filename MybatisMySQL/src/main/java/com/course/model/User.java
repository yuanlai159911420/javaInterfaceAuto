package com.course.model;

import lombok.Data;

@Data
public class User {
    private int id;
    private String username;
    private String password;
    private int age;
    private String sex;
    private String permission;
    private String isDelete;

    @Override
    public String toString() {
        return "{"
                + "id: " + this.id + ", "
                + "username: " + this.username + ", "
                + "password: " + this.password + ", "
                + "age: " + this.age + ", "
                + "sex: " + this.sex + ", "
                + "permission: " + this.permission + ", "
                + "isDelete: " + this.isDelete
                + "}";
    }
}
