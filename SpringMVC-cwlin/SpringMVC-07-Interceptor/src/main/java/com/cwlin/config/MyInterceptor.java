package com.cwlin.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
    @Override //在请求处理的方法之前执行
    //如果返回true执行下一个拦截器，如果返回false就不执行下一个拦截器
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("===========处理前===========");
        return true;
    }

    @Override //在请求处理的方法之后执行
    //但是它会在 DispatcherServlet 进行视图的渲染之前执行，也就是说在这个方法中你可以对ModelAndView进行操作，可以用来写日志
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("===========处理后===========");
    }

    @Override //在 DispatcherServlet 处理后执行，做清理工作
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("===========清理===========");
    }
}
