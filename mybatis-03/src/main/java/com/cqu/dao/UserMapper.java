package com.cqu.dao;

import com.cqu.pojo.User;


public interface UserMapper {

    // 根据ID查询用户
    User getUserById(int id);

}
