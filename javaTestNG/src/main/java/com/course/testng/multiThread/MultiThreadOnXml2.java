package com.course.testng.multiThread;

import org.testng.annotations.Test;

public class MultiThreadOnXml2 {

    @Test
    public void test1(){
        System.out.printf("MultiThreadOnXml2.timeOutSuccess 的 Thread Id : %s%n", Thread.currentThread().getId());
    }
}
