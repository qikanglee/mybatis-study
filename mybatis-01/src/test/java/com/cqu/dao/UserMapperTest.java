package com.cqu.dao;

import com.cqu.pojo.User;
import com.cqu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {

    @Test
    public void test() {
        // 第一步，获得sqlSession对象
        SqlSession sqlSession = null;

        try {
            sqlSession = MybatisUtils.getSqlSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = mapper.getUserList();
            for (User user : userList) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            // 关闭 sqlSession
            sqlSession.close();
        }
        // 方式一：getMapper 执行SQL
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        List<User> userList = mapper.getUserList();

        // 方式二：不推荐
//        List<Object> userList = sqlSession.selectList("com.cqu.dao.UserDao.getUserList");

//        for (User user:userList){
//            System.out.println(user);
    }

    @Test
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> values = mapper.getUserLike("%李%");

        for(User user:values){
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void getUserById() {
        // 第一步，获得sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 第二部，获得mapper对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 第三步，操作mapper方法，进行数据库操作
        User userById = mapper.getUserById(1);
        System.out.println(userById);

        // 关闭资源
        sqlSession.close();
    }

    // 增删改需要提交事务
    @Test
    public void addUser() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);


        int res = mapper.addUser(new User(4, "李琪康", "123123"));
        if (res > 0) {
            System.out.println("插入成功！");
        }

        // 提交事务
        sqlSession.commit();
        // 关闭资源
        sqlSession.close();

    }

    @Test
    public void addUser2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId","6");
        map.put("userName","李胖鱼");
        map.put("password","111111");
        mapper.addUser2(map);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
     public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.updateUser(new User(1,"戴宇","daiyu"));

        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void deleteUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(4);

        sqlSession.commit();
        sqlSession.close();
    }
}
