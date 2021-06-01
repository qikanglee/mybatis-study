package com.cqu.dao;

import com.cqu.pojo.User;
import com.cqu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {

    @Test
    public void getUserList(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = mapper.getUserList();

        for(User user : userList){
            System.out.println(user);
        }

        sqlSession.close();
    }
}
