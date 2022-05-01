package com.course.testng.multiThread;

import org.testng.annotations.Test;

public class MultiThreadOnXml {

    @Test
    public void test1(){
        System.out.printf("MultiThreadOnXml.timeOutSuccess 的 Thread Id : %s%n", Thread.currentThread().getId());
    }

    @Test
    public void test2(){
        System.out.printf("MultiThreadOnXml.test2 的 Thread Id : %s%n", Thread.currentThread().getId());
    }

    @Test
    public void test3(){
        System.out.printf("MultiThreadOnXml.test3 的Thread Id : %s%n", Thread.currentThread().getId());
    }
}
