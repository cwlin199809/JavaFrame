package com.cwlin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EncodingErrorController {
    @PostMapping("/e1/t1")
    public String test1(String name, Model model){
        System.out.println(name);
        model.addAttribute("msg", name); //获取表单提交的值
        return "test"; //跳转到test页面显示输入的值
    }
}
