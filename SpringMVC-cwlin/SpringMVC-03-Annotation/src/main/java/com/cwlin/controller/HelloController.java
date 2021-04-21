package com.cwlin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/HelloController")
public class HelloController {
    //真实访问地址: IP:端口号/HelloController/hello
    @RequestMapping("/hello")
    public String hello(Model model){
        //封装数据：向模型中添加属性msg与值，可以在JSP页面中取出并渲染
        model.addAttribute("msg","Hello, SpringMVCAnnotation!");
        //web-inf/jsp/hello.jsp
        return "hello"; //会被视图解析器处理
    }
}
