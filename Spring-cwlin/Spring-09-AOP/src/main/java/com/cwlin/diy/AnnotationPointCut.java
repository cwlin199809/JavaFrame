package com.cwlin.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//方式三：使用注解方式实现AOP
@Aspect //标注这个类是一个切面
public class AnnotationPointCut {
    @Before("execution(* com.cwlin.service.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("------------方法执行前------------");
    }
    @After("execution(* com.cwlin.service.UserServiceImpl.*(..))")
    public void after(){
        System.out.println("------------方法执行后------------");
    }
    //在环绕增强中，可以给定一个参数，代表我们要处理的切入点
    @Around("execution(* com.cwlin.service.UserServiceImpl.*(..))")
    public Object around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("环绕前");

        Signature signature = jp.getSignature(); //获得签名
        System.out.println(signature);

        //执行方法
        Object proceed = jp.proceed();

        System.out.println("环绕后");
        return proceed;
    }
}
