package com.course.testng;

import org.testng.annotations.Test;

public class IgnoreTest {

    @Test
    public void ignore1() {
        System.out.println("Ignore1 执行");
    }

    // 忽略测试，加上 enabled 属性在执行 test 时就不会执行该方法
    @Test(enabled = false)
    public void ignore2() {
        System.out.println("Ignore2 执行");
    }
}
