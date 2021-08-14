package com.cwlin.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {
    //将自定义的Druid配置进IOC容器
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    //配置 Druid 监控管理后台的Servlet
    //内置 Servlet 容器时没有web.xml文件，所以使用 Spring Boot 的注册 Servlet 方式
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(
                new StatViewServlet(), "/druid/*");
        //后台需要有人登录，账号密码配置
        HashMap<String, String> initParameters = new HashMap<>();
        //增加配置
        //这些参数可以在com.alibaba.druid.support.http.StatViewServlet的父类ResourceServlet中找到
        initParameters.put("loginUsername","admin"); //后台管理界面的登录账号
        initParameters.put("loginPassword","123456"); //后台管理界面的登录密码

        //Druid 后台允许谁可以访问 allow
        //initParameters.put("allow", "localhost")：表示只有本机可以访问
        //initParameters.put("allow", "")：为空或者为null时，表示允许所有访问
        initParameters.put("allow", "");
        //Druid 后台禁止谁可以访问deny
        initParameters.put("deny", "192.168.1.66"); //表示禁止此ip访问

        //设置初始化参数
        bean.setInitParameters(initParameters);
        return bean;
    }

    //配置 Druid 监控 之  web 监控的 filter
    //WebStatFilter：用于配置Web和Druid数据源之间的管理关联监控统计
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        //exclusions：设置哪些请求进行过滤排除掉，从而不进行统计
        Map<String, String> initParameters = new HashMap<>();
        initParameters.put("exclusions", "*.js,*.css,/druid/*,/jdbc/*");
        bean.setInitParameters(initParameters);
        //"/*" 表示过滤所有请求
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }
}
