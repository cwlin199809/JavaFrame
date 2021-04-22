package com.cwlin.controller;

import com.cwlin.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("/t1") //http://localhost:8099/user/t1?username=cwlin
    //从前端接收的参数，建议都加上@RequestParam
    public String test1(@RequestParam("username") String name, Model model){
        //1.接收前端参数
        System.out.println("接收到前端的参数为: " + name);
        //2.将返回的结果传递到前端
        model.addAttribute("msg", name);
        //3.视图跳转
        return "test";
    }

    /*
        1.接收前端用户传递的参数，判断参数名，若参数名直接在方法上，则直接使用
        2.假设传递的是一个User对象，匹配User对象的字段名，若名字一致则成功；否则匹配不到返回null
     */
    @GetMapping("/t2") //http://localhost:8099/user/t2?name=cwlin&id=1&age=3
    public String test2(@RequestParam("user")User user, Model model){
        //1.接收前端参数
        System.out.println("接收到前端的参数为: " + user);
        //2.将返回的结果传递到前端
        model.addAttribute("msg", user);
        //3.视图跳转
        return "test";
    }
}
