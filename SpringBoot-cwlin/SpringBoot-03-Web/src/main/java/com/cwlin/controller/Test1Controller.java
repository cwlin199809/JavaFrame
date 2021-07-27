package com.cwlin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
public class Test1Controller {
    @RequestMapping("/test1")
    public String test1(Model model){
        model.addAttribute("msg","<h1>hello, Thymeleaf!<h1>");
        model.addAttribute("users", Arrays.asList("cwlin","coder_lcw"));
        //classpath:/templates/test.html
        return "test1";
    }
}
