package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "student")
public class GroupsOnClass1 {

    public void student1() {
        System.out.println("GroupsOnClass1 类中的 student1 执行");
    }

    public void student2() {
        System.out.println("GroupsOnClass1 类中的 student2 执行");
    }
}
