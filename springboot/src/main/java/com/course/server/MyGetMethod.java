package com.course.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@Api(value = "/", description = "这是我全部的get方法")
public class MyGetMethod {

    /**
     * 实现一个返回cookie信息的接口
     *
     * @param response
     * @return
     */
    @RequestMapping(value = "/getCookies", method = RequestMethod.GET)
    @ApiOperation(value = "通过这个方法可以获取到cookie值", httpMethod = "GET")
    public String getCookies(HttpServletResponse response) {
        // HttpServletRequest 装请求信息的类
        // HttpServletResponse 装响应信息的类
        // 设置cookie
        Cookie cookie = new Cookie("login", "true");
        response.addCookie(cookie);
        return "恭喜你获取cookies成功";
    }

    /**
     * 这是一个需要携带cookie信息才能反问的get请求
     * @param request
     * @return
     */
    @RequestMapping(value = "/get/with/cookies", method = RequestMethod.GET)
    @ApiOperation(value = "这是一个需要携带cookie信息才能反问的get请求", httpMethod = "GET")
    public String getWithCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)) {
            return "你必须携带cookie信息才能访问";
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login") && cookie.getValue().equals("true")) {
                return "恭喜你访问成功";
            }
        }
        return "cookie信息错误";
    }

    /**
     * 这是一个需要携带参数才能访问的get请求
     * 第一种实现方法
     * @param start
     * @param end
     * @return
     */
    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    @ApiOperation(value = "这是一个需要携带参数才能访问的get请求", httpMethod = "GET")
    public Map<String, Integer> getList(@RequestParam Integer start, @RequestParam Integer end){
        // 无序map集合
        Map<String, Integer> myList = new HashMap<>();
        myList.put("奥迪", 10000);
        myList.put("运动鞋", 300);
        myList.put("方便面", 5);

        return myList;
    }

    /**
     * 带参数访问的get请求的第二种写法
     * url  ip:端口号/地址/参数1/参数2
     * @param start
     * @param end
     * @return
     */
    @RequestMapping(value = "/get/list/{start}/{end}")
    @ApiOperation(value = "带参数访问的get请求的第二种写法", httpMethod = "GET")
    public Map<String, Integer> myGetList(@PathVariable Integer start, @PathVariable Integer end){
        // 有序map集合
        Map<String, Integer> myList = new LinkedHashMap<>();
        myList.put("运动鞋", 400);
        myList.put("汽水", 6);
        myList.put("面包", 3);
        return myList;
    }
}
