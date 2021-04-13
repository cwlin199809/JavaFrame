package com.cwlin.dao;

import com.cwlin.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> selectUser();

    //插入用户
    int insertUser(User user);

    //删除用户
    int deleteUser(int id);
}
