package com.course.httpclient.demo;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.charset.Charset;

public class MyHttpClient {

    @Test
    public void test1() throws IOException {

        //用来存放返回的结果
        String result;
        HttpGet httpGet = new HttpGet("https://www.baidu.com");
        // 用户执行get方法
//        HttpClient httpClient = new DefaultHttpClient();
        HttpClient client = HttpClientBuilder.create().build();
        // 访问百度，获取访问结果
        HttpResponse httpResponse = client.execute(httpGet);
        // 将返回结果转化成字符串
        result = EntityUtils.toString(httpResponse.getEntity(), "utf-8");
        System.out.println(result);
    }
}
