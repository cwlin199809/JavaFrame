package com.cwlin.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("uri: " + request.getRequestURI());
        HttpSession session = request.getSession();
        //放行：判断什么情况下已经登录
        //已经是登陆页面
        if(request.getRequestURI().contains("goLogin")){
            return true;
        }
        //正在提交登录
        if(request.getRequestURI().contains("login")){
            return true;
        }
        //第一次登录，也是没有session的
        if(session.getAttribute("userLoginInfo") != null){
            return true;
        }
        //拦截：判断什么情况下没有登录
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        return false;
    }
}
