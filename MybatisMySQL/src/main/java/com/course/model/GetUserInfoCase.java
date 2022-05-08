package com.course.model;

import lombok.Data;

@Data
public class GetUserInfoCase {
    private int userID;
    private String expected;

    @Override
    public String toString(){
        return "{"
                + "userID: " + this.userID + ", "
                + "expected: " + this.expected
                + "}";
    }
}
