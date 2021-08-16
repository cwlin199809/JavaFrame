package com.cwlin.swagger.controller;

import com.cwlin.swagger.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "Hello控制类")
public class HelloController {
    @RequestMapping(value = "/hello")
    public String hello(){
        return "Hello, swagger!";
    }

    @PostMapping("/getUser")
    public User getUser(){
        int num = 6/0; //500错误
        return new User();
    }

    @PostMapping("/helloUser")
    @ApiOperation("helloUser方法")
    public String helloUser(@ApiParam("用户名") @RequestParam("username") String username){
        return "Hello, " + username + "!";
    }
}
