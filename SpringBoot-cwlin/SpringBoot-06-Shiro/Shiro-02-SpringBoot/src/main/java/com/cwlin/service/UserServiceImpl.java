package com.cwlin.service;

import com.cwlin.mapper.UserMapper;
import com.cwlin.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User selectUserByName(String name) {
        return userMapper.selectUserByName(name);
    }

    @Override
    public List<User> selectUserList() {
        return null;
    }

    @Override
    public User selectUserById(int id) {
        return null;
    }

    @Override
    public int insertUser(User user) {
        return 0;
    }

    @Override
    public int updateUser(User user) {
        return 0;
    }

    @Override
    public int deleteUser(int id) {
        return 0;
    }
}
