package com.cwlin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RestFulController {
    //原来的: http://localhost:8099/add?a=1&b=2
    //RestFul: http://localhost:8099/add/1/2

    @RequestMapping("/add1/{a}/{b}")
    public String test1(@PathVariable int a, @PathVariable String b, Model model){
        String res = a + b;
        model.addAttribute("msg", "结果为"+res);
        return "test";
    }

    @GetMapping("/add2/{a}/{b}")
    public String test2(@PathVariable int a, @PathVariable String b, Model model){
        String res = a + b;
        model.addAttribute("msg", "结果为"+res);
        return "test";
    }

    @PostMapping("/add3/{a}/{b}")
    public String test3(@PathVariable int a, @PathVariable String b, Model model){
        String res = a + b;
        model.addAttribute("msg", "结果为"+res);
        return "test";
    }


    @DeleteMapping("/add4/{a}/{b}")
    public String test4(@PathVariable int a, @PathVariable String b, Model model){
        String res = a + b;
        model.addAttribute("msg", "结果为"+res);
        return "test";
    }

    @RequestMapping(value="/add5/{a}/{b}", method=RequestMethod.DELETE)
    public String test5(@PathVariable int a, @PathVariable int b, Model model){
        int res = a + b;
        model.addAttribute("msg", "结果为"+res);
        return "test";
    }
}
