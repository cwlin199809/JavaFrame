package com.cwlin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

//全面扩展SpringMVC  DispatchServlet
@Configuration
public class MyMVCConfig implements WebMvcConfigurer {
    //viewResolver实现了视图解析器接口类，就可以把它看作是视图解析器

    @Bean
    public ViewResolver myViewResolver(){
        return new MyViewResolver();
    }

    //静态内部类，视图解析器就需要实现ViewResolver接口
    private static class MyViewResolver implements ViewResolver {
        @Override
        public View resolveViewName(String s, Locale locale) {
            return null;
        }
    }
}
