package com.cwlin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RouterController {
    @RequestMapping({"/","/index"})
    public String index(){
        return "index";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "views/login";
    }

    @RequestMapping("/{level}/{id}")
    public String level1(@PathVariable("level") String level, @PathVariable("id") String id){
        return "views/"+level+"/"+id;
    }

    @RequestMapping("/user/toUserCenter")
    public String toUserCenter(){
        return "views/userCenter";
    }
}
