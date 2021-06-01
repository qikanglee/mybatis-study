package com.cqu.dao;

import com.cqu.pojo.User;

import java.util.List;
import java.util.Map;


public interface UserMapper {
    // 查询全部用户
    List<User> getUserList();

    //模糊查询
    List<User> getUserLike(String value);

    // 根据ID查询用户
    User getUserById(int id);

    // insert 一个用户
    int addUser(User user);

    // map插入用户
    int addUser2(Map<String, Object> map);

    // 修改用户
    int updateUser(User user);

    // 删除用户
    int deleteUser(int id);
}
