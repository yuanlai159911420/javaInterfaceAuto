package com.course.model;

import lombok.Data;

@Data
public class UpdateUserInfoCase {
    private int id;
    private int userID;
    private String username;
    private String sex;
    private int age;
    private String permission;
    private String isDelete;
    private String expected;

    @Override
    public String toString(){
        return "{"
                + "id: " + this.id + ", "
                + "userID: " + this.userID + ", "
                + "username: " + this.username + ", "
                + "sex: " + this.sex + ", "
                + "age: " + this.age + ", "
                + "permission: " + this.permission + ", "
                + "isDelete: " + this.isDelete + ", "
                + "expected: " + this.expected
                + "}";
    }
}
