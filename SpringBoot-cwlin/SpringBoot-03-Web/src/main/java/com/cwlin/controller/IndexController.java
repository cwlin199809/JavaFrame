package com.cwlin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// 在templates目求下的所有页面，只能通过controller来跳转！
// 这个需要模板引擎的支持，thymeleaf依赖
public class IndexController {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
