package com.course.cases;

import com.course.model.AddUserCase;
import com.course.utils.DatabaseUtils;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddUserTest {

    @Test(groups = "loginTrue", description = "添加用户")
    public void addUser() throws IOException {
        SqlSession sqlSession = DatabaseUtils.getSqlSession();
        AddUserCase addUserCase = sqlSession.selectOne("addUserCase", 1);
        System.out.println(addUserCase.toString());
    }
}
