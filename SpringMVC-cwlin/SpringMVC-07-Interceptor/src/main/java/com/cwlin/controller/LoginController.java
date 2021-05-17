package com.cwlin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LoginController {
    @RequestMapping("/main")
    public String main(){
        return "main";
    }

    @RequestMapping("/goLogin")
    public String login(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(HttpSession session, String username, String password, Model model){
        //把用户信息存在session中
        session.setAttribute("userLoginInfo", username);
        model.addAttribute("username",username);
        model.addAttribute("password",password);
        return "main";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate(); //销毁Session，更优
        //session.removeAttribute("userLoginInfo"); //删除Session的内容
        return "redirect:main"; //使用重定向，避免注销两次
    }
}
