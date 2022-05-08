package com.course.cases;

import com.course.model.GetUserInfoCase;
import com.course.utils.DatabaseUtils;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetUserInfoTest {

    @Test(groups = "loginTrue", description = "获取userID为1的用户信息")
    public void getUserInfo() throws IOException {
        SqlSession sqlSession = DatabaseUtils.getSqlSession();
        GetUserInfoCase getUserInfoCase = sqlSession.selectOne("getUserInfoCase", 1);
        System.out.println(getUserInfoCase);
    }
}
