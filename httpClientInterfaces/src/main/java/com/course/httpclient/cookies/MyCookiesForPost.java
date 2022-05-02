package com.course.httpclient.cookies;

import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPost {

    private String url;
    private ResourceBundle bundle;
    private final CookieStore cookieStore = new BasicCookieStore();

    @BeforeTest
    public void beforeTest() {
        this.bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        this.url = this.bundle.getString("testUrl");
    }

    @Test
    public void getCookies() throws URISyntaxException, IOException {
        // 创建url对象
        URIBuilder uriBuilder = new URIBuilder(this.url + this.bundle.getString("getCookies"));
        // 建立访问对象
        HttpGet get = new HttpGet(uriBuilder.build());
        // 创建client对象，并获取cookie信息
        CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(this.cookieStore).build();
        HttpResponse response = client.execute(get);
        // 将返回信息转换成字符串
        String result = EntityUtils.toString(response.getEntity());
        System.out.println(result);
        // 提取cookie信息
        List<Cookie> cookieList = this.cookieStore.getCookies();
        // 打印cookie信息
        for (Cookie cookie : cookieList) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("name = " + name + ", value = " + value);
        }
    }

    /**
     * 参数为json格式时，使用该方法
     * @throws IOException
     */
    @Test(dependsOnMethods = {"getCookies"})
    public void postWithJson() throws IOException {
        // 创建client对象
        CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(this.cookieStore).build();
        // 创建post对象
        HttpPost post = new HttpPost(this.url + this.bundle.getString("post.with.json"));
        //设置请求头信息
        post.setHeader("content-type", "application/json; charset=utf-8");
        //添加参数
        JSONObject param = new JSONObject();
        param.put("name", "李四");
        param.put("sex", "男");
        //设置请求参数
        StringEntity entity = new StringEntity(param.toString(), "utf-8");
        post.setEntity(entity);
        //执行访问接口
        CloseableHttpResponse response = client.execute(post);
        //判断响应结果是否正确
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode == 200) {
            //声明一个对象来存储响应结果
            String result = EntityUtils.toString(response.getEntity());
            System.out.println(result);

            //将响应结果转化成json格式
            JSONObject resultJSON = new JSONObject(result);
            //提取json字符串
            String code = resultJSON.get("code").toString();
            String msg = resultJSON.getString("msg");
            //判断预期结果和实际结果
            Assert.assertEquals("1", code);
            Assert.assertEquals("返回一个json格式的数据", msg);
        }
    }

    /**
     * 参数为表单时使用该方式传参数
     * @throws URISyntaxException
     * @throws IOException
     */
    @Test(dependsOnMethods = {"getCookies"})
    public void postWithCookies() throws URISyntaxException, IOException {
        //创建uri地址对象
        URIBuilder uriBuilder = new URIBuilder(this.url + this.bundle.getString("post.with.cookies"));
        //创建client对象，并引入cookie
        CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(this.cookieStore).build();
        //创建post请求对象
        HttpPost post = new HttpPost(uriBuilder.build());
        //设置参数，这种添加只适用于get请求
//        uriBuilder.setParameter("name", "李四");
//        uriBuilder.setParameter("sex", "男");
        List<NameValuePair> pairList = new ArrayList<>(2);
        pairList.add(new BasicNameValuePair("name", "胡汉三"));
        pairList.add(new BasicNameValuePair("age", "18"));
        System.out.println(pairList);
        //构造一个form表单
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(pairList, Consts.UTF_8);
        System.out.println(formEntity);
        //将参数添加到请求中
        post.setEntity(formEntity);
        //设置header信息
        post.setHeader("content-type", "application/json; charset=utf-8");
        //执行请求
        CloseableHttpResponse response = client.execute(post);
        String result = EntityUtils.toString(response.getEntity());
        System.out.println(result);
        //获取响应码
        int statusCode = response.getStatusLine().getStatusCode();
        //判断结果
        if (statusCode == 200){
            //将响应结果转化为json格式
            JSONObject resultJSON = new JSONObject(result);
            Assert.assertEquals(200, resultJSON.get("code"));
            Assert.assertEquals("操作成功", resultJSON.getString("msg"));
        }
    }
}
