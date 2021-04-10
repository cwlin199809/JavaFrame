package com.cwlin.config;

import com.cwlin.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//@Configuration  这个也会被Spring容器托管，注册到容器中，因为打开注解，它本身就被定义为组件了@Component
//@Configuration  该注解代表了这是一个配置类，与applicationContext.xml一样
@Configuration
@ComponentScan("com.cwlin.pojo")
@Import(CwlinConfig2.class) //导入合并其他配置类，类似于配置文件中的 inculde 标签
public class CwlinConfig {
    //注册一个Bean，就相当于我们之前写的一个bean标签
    //方法名 == bean标签的id
    //方法返回值 == bean标签中的class属性
    @Bean
    public User getUser(){
        return new User(); //就是返回要注入到bean的对象
    }
}
