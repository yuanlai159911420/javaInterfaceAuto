package com.course.controller;

import com.course.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Log4j
@RestController
@Api(value = "v1", description = "这是我第一个版本的demo")
@RequestMapping("v1")
public class Demo {

    // 启动即加载，类一启动，这个对象就被赋值了
    @Autowired
    private SqlSessionTemplate template;

    @RequestMapping(value = "/get/user/count", method = RequestMethod.GET)
    @ApiOperation(value = "可以获取到用户数", httpMethod = "GET")
    public int getUserCount(){
        return template.selectOne("getUserCount");
    }

    @RequestMapping(value = "/add/user", method = RequestMethod.POST)
    @ApiOperation(value = "增加一个用户", httpMethod = "POST")
    public int addUser(@RequestBody User user){
        return template.insert("addUser", user);
    }

    @RequestMapping(value = "/update/user", method = RequestMethod.POST)
    @ApiOperation(value = "更新用户信息", httpMethod = "POST")
    public int updateUser(@RequestBody User user){
        return template.update("updateUser", user);
    }

    @RequestMapping(value = "/del/user", method = RequestMethod.GET)
    @ApiOperation(value = "删除用户", httpMethod = "GET")
    public int delUser(@RequestParam int id){
        return template.delete("delUser", id);
    }
}
