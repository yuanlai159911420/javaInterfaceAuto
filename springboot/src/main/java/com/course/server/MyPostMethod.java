package com.course.server;

import com.course.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@RestController
@Api(value = "/", description = "这是我全部的post请求")
@RequestMapping(value = "/v1")
public class MyPostMethod {

    // 这个变量是用来装cookie信息的
    private static Cookie cookie;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "登陆接口，获取cookie信息", httpMethod = "POST")
    public String login(HttpServletResponse response,
                        @RequestParam(value = "username") String username,
                        @RequestParam(value = "password") String password) {
        if (username.equals("张三") && password.equals("123456")) {
            // 设置cookies
            cookie = new Cookie("login", "true");
            // cookie信息添加到返回信息
            response.addCookie(cookie);
            return "恭喜你登陆成功";
        }

        return "输入的用户名或者密码错误";
    }

    @RequestMapping(value = "/get/user/list", method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表", httpMethod = "POST")
    public String getUserList(HttpServletRequest request,
                              @RequestBody User user) {
        User user1;
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)) {
            return "cookie信息为空";
        }
        for (Cookie c : cookies) {
            if (user.getUsername().equals("张三")
                    && user.getPassword().equals("123456")
                    && c.getName().equals("login")
                    && c.getValue().equals("true")) {
                user1 = new User();
                user1.setName("李四");
                user1.setAge("20");
                user1.setSex("男");

                return user1.toString();
            }
        }

        return "参数不合法";
    }
}
