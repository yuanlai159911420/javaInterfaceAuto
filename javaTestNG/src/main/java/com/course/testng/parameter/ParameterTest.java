package com.course.testng.parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {

    @Test
    @Parameters(value = {"name", "age"})
    public void parametersTest1(String name, int age){
        System.out.println("name = " + name + ", age = " + age);
    }
}
