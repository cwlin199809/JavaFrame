package com.cwlin.controller;

import com.cwlin.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AjaxController {
    @RequestMapping("/t1")
    public String test(){
        return "hello";
    }

    @RequestMapping("/a1")
    public void a1(String name, HttpServletResponse response) throws IOException {
        System.out.println("a1:param -> "+name);
        if("cwlin".equals(name)){
            response.getWriter().print("true");
        }else{
            response.getWriter().print("false");
        }
    }

    @RequestMapping("/a2")
    public List<User> a2() {
        List<User> userList = new ArrayList<>();

        //添加数据
        userList.add(new User("cwlin",3,"男"));
        userList.add(new User("lcw",18,"男"));
        userList.add(new User("coder_lcw",24,"男"));

        return userList;
    }

    @RequestMapping("/a3")
    public String a3(String name, String pwd){
        String msg = "";
        //模拟数据库中存在的数据，admin 数据应该在数据库中查询
        if (name != null){
            if ("admin".equals(name)) {
                msg = "OK";
            }else {
                msg = "用户名输入错误";
            }
        }
        if (pwd != null){
            if ("123456".equals(pwd)) {
                msg = "OK";
            }else {
                msg = "密码输入错误";
            }
        }
        return msg;
    }
}
