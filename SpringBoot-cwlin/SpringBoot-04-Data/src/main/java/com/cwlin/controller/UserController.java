package com.cwlin.controller;

import com.cwlin.mapper.UserMapper;
import com.cwlin.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mybatis")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/selectUserList")
    public List<User> selectUserList(){
        List<User> userList = userMapper.selectUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        return userList;
    }

    @GetMapping("/selectUserById")
    public User selectUserById(){
        User user = userMapper.selectUserById(1);
        System.out.println(user);
        return user;
    }

    @GetMapping("/insertUser")
    public String addUser(){
        int i = userMapper.insertUser(new User(6, "coder_lcw", "123456"));
        System.out.println("返回在数据库中影响的行数为："+i);
        return "insertUser: OK!";
    }

    @GetMapping("/updateUser")
    public String updateUser(){
        int i = userMapper.updateUser(new User(6, "lcw", "123456"));
        System.out.println("返回在数据库中影响的行数为："+i);
        return "updateUser: OK!";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(){
        int i = userMapper.deleteUser(6);
        System.out.println("返回在数据库中影响的行数为："+i);
        return "deleteUser: OK!";
    }
}
