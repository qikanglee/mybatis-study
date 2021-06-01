package com.cqu.dao;

import com.cqu.pojo.Teacher;
import com.cqu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {

    @Test
    public void getTeacherTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        Teacher teacherAndStudent = mapper.getTeacherAndStudent2(1);

        System.out.println(teacherAndStudent);

        sqlSession.close();
    }
}
