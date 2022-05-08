package com.course.cases;

import com.course.model.GetUserListCase;
import com.course.utils.DatabaseUtils;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetUserListTest {

    @Test(groups = "loginTrue", description = "获取性别为男的用户信息")
    public void getUserList() throws IOException {
        SqlSession sqlSession = DatabaseUtils.getSqlSession();
        GetUserListCase getUserListCase = sqlSession.selectOne("getUserListCase", 1);
        System.out.println(getUserListCase);
    }
}
