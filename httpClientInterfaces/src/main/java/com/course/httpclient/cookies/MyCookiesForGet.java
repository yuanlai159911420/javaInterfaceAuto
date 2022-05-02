package com.course.httpclient.cookies;

import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {

    private String url;
    private ResourceBundle bundle;
    private final CookieStore store = new BasicCookieStore();

    @BeforeTest
    public void beforeTest(){
        this.bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        this.url = this.bundle.getString("testUrl");
    }

    @Test
    public void getCookies() throws IOException {
        String result;
        // 书写逻辑代码
        HttpGet get = new HttpGet(this.url + this.bundle.getString("getCookies"));
//        HttpClient client = HttpClientBuilder.create().build();
        // 创建一个可关闭的httpClient对象
//        CloseableHttpClient client = HttpClients.createDefault();
        // 设置cookies信息
//        CookieStore store = new BasicCookieStore();
        // 创建client对象
        CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(this.store).build();

//        HttpResponse response = client.execute(get);
        CloseableHttpResponse response = client.execute(get);

        result = EntityUtils.toString(response.getEntity());
        System.out.println(result);

//        CookieStore store = client

        List<Cookie> cookieList = this.store.getCookies();
        for (Cookie cookie: cookieList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name = " + name + ", cookie value = " + value);
        }
    }

    @Test(dependsOnMethods = {"getCookies"})
    public void getWithCookies() throws IOException, URISyntaxException {
        // 构建uri对象
        URIBuilder uri = new URIBuilder(this.url + this.bundle.getString("get.with.cookies"));
        // 添加请求参数
        uri.setParameter("name", "张三");

        // 发送请求
//        HttpGet get = new HttpGet(this.url + this.bundle.getString("get.with.cookies"));
        HttpGet get = new HttpGet(uri.build());
        // 添加cookie信息
        CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(this.store).build();

        CloseableHttpResponse response = client.execute(get);
        // 获取状态码
        int statusCode = response.getStatusLine().getStatusCode();

        if (statusCode == 200){
            String result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
        }
    }
}
