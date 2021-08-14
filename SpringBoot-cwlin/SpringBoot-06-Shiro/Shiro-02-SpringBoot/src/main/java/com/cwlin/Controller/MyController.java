package com.cwlin.Controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
    @RequestMapping({"/","/index"})
    public String toIndex(Model model) {
        model.addAttribute("msg","Hello, Shiro!");
        return "index";
    }

    @RequestMapping("/user/insert")
    public String insertUser() {
        return "user/insert";
    }

    @RequestMapping("/user/update")
    public String updateUser() {
        return "user/update";
    }

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String username, String password, Model model) {
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户的登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        //执行登录操作
        try {
            subject.login(token);
            return "index";
        }  catch (UnknownAccountException e) { //用户名不存在
            model.addAttribute("msg","用户名不存在");
            return "login";
        } catch (IncorrectCredentialsException e) { //密码错误
            model.addAttribute("msg","密码错误");
            return "login";
        } catch (LockedAccountException e) { //账户锁定
            model.addAttribute("msg","账户锁定");
            return "login";
        } catch (AuthenticationException e) { //认证异常
            model.addAttribute("msg","认证出现异常");
            return "login";
        }
    }

    @RequestMapping("/unauthorized")
    @ResponseBody
    public String unauthorized() {
        return "未经授权，无法访问此页面！";
    }
}
