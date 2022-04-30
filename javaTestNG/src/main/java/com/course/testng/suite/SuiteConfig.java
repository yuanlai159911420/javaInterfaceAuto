package com.course.testng.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class SuiteConfig {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BeforeSuite开始运行");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite开始运行");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("BeforeTest开始运行");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("AfterTest开始运行");
    }
}
