package com.cwlin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping("/test")
    public String test1(Model model){
        model.addAttribute("msg","hello, Thymeleaf!");
        //classpath:/templates/test.html
        return "test";
    }
}
