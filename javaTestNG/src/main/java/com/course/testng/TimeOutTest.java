package com.course.testng;

import org.testng.annotations.Test;

public class TimeOutTest {

    @Test(timeOut = 3000)   //单位为毫秒
    public void timeOutSuccess() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("这是成功的超时测试");
    }

    @Test(timeOut = 2000)
    public void timeOutFailed() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("这是失败的超时测试");
    }

}
