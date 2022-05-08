package com.course.model;

import lombok.Data;

@Data
public class GetUserListCase {
    private String username;
    private int age;
    private String sex;
    private String expected;

    @Override
    public String toString(){
        return "{"
                + "username: " + this.username + ", "
                + "age: " + this.age + ", "
                + "sex: " + this.sex + ", "
                + "expected: " + this.expected
                + "}";
    }
}
