package com.course.cases;

import com.course.model.UpdateUserInfoCase;
import com.course.utils.DatabaseUtils;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

public class UpdateUserInfoTest {

    @Test(groups = "loginTrue", description = "更新userID为1的用户")
    public void updateUserInfo() throws IOException {
        SqlSession sqlSession = DatabaseUtils.getSqlSession();
        UpdateUserInfoCase updateUserInfoCase = sqlSession.selectOne("updateUserInfoCase", 1);
        System.out.println(updateUserInfoCase);
    }

    @Test(groups = "loginTrue", description = "删除userID为2的用户")
    public void deleteUserInfo() throws IOException {
        SqlSession sqlSession = DatabaseUtils.getSqlSession();
        UpdateUserInfoCase updateUserInfoCase = sqlSession.selectOne("updateUserInfoCase", 2);
        System.out.println(updateUserInfoCase);
    }
}
