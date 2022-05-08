package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.InterfacesName;
import com.course.model.LoginCase;
import com.course.utils.ConfigFile;
import com.course.utils.DatabaseUtils;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClients;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest {

    @BeforeTest(groups = "loginTrue", description = "登陆成功，获取httpclient信息")
    public void beforeTest(){
        TestConfig.loginUrl = ConfigFile.getUrl(InterfacesName.Login);
        TestConfig.addUserUrl = ConfigFile.getUrl(InterfacesName.AddUserInfo);
        TestConfig.getUserInfoUrl = ConfigFile.getUrl(InterfacesName.GetUserInfo);
        TestConfig.getUserListUrl = ConfigFile.getUrl(InterfacesName.GetUserList);
        TestConfig.updateUserInfoUrl = ConfigFile.getUrl(InterfacesName.UpdateUserInfo);
        TestConfig.store = new BasicCookieStore();
        TestConfig.client = HttpClients.custom().setDefaultCookieStore(TestConfig.store).build();
    }

    @Test(groups = "loginTure", description = "用户登陆成功的接口测试")
    public void loginTrue() throws IOException {
        SqlSession sqlSession = DatabaseUtils.getSqlSession();
        LoginCase loginCase = sqlSession.selectOne("loginCase", 1);
//        User user = sqlSession.selectOne("user", 1);
        System.out.println(loginCase.toString());
    }

    @Test(groups = "loginFalse", description = "用户登陆失败的接口测试")
    public void loginFalse() throws IOException {
        SqlSession sqlSession = DatabaseUtils.getSqlSession();
        LoginCase loginCase = sqlSession.selectOne("loginCase", 2);
        System.out.println(loginCase.toString());
    }
}
