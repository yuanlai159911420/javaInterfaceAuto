package com.course.testng.parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {

    @Test(dataProvider = "test1")
    public void dataProviderTest1(String name, int age){
        System.out.println("name = " + name + ", age = " + age);
    }

    @DataProvider(name = "test1")
    public Object[][] providerData(){
        Object[][] objects = new Object[][]{
                {"张三", 20},
                {"李四", 30},
                {"王五", 21}
        };

        return objects;
    }

    @Test(dataProvider = "methodData")
    public void dataProviderTest2(String name, int age){
        System.out.println("dataProviderTest2 的 name = " + name + ", age = " + age);
    }

    @Test(dataProvider = "methodData")
    public void dataProviderTest3(String name, int age){
        System.out.println("dataProviderTest3 的 name = " + name + ", age = " + age);
    }

    @DataProvider(name = "methodData")
    public Object[][] methodTestData(Method method){
        Object[][] objects = null;
        if (method.getName().equals("dataProviderTest2")){
            objects = new Object[][]{
                    {"张三", 20},
                    {"李四", 30}
            };
        } else if (method.getName().equals("dataProviderTest3")) {
            objects = new Object[][]{
                    {"王五", 40},
                    {"赵六", 50}
            };
        }

        return objects;
    }
}
