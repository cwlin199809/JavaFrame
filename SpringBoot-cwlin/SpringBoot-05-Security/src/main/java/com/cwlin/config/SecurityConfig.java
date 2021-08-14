package com.cwlin.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //请求授权的规则：首页所有人都可访问，功能页需要相应权限
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");

        //没有权限，跳转到默认登录页面：http://localhost:8080/login
        http.formLogin().loginPage("/toLogin") //自定义登录页面
                .usernameParameter("username").passwordParameter("password") //自定义用户名和密码的参数
                .loginProcessingUrl("/user/login"); //指定表单提交url

        //开启注销功能，跳转到默认注销首页：http://localhost:8080/logout
        http.logout().logoutSuccessUrl("/"); //注销成功后跳转到 "/" 的Controller
        http.csrf().disable(); //版本不同问题，可能会出现注销失败，关闭csrf

        //开启记住我功能，本质就是记住一个cookies，默认保存2周
        http.rememberMe().rememberMeParameter("remember");
    }

    //认证
    //Spring Boot 2.1.x 可以直接使用
    //Spring Security 5.0 以后默认需要密码加密方式，设置密码编码 passwordEncoder
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //这些数据一般从数据库中读取，这里是在内存中测试数据
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("cwlin").password(new BCryptPasswordEncoder().encode("123456"))
                .roles("vip2","vip3")
                .and()
                .withUser("admin").password(new BCryptPasswordEncoder().encode("123456"))
                .roles("vip1","vip2","vip3")
                .and()
                .withUser("guest").password(new BCryptPasswordEncoder().encode("123456"))
                .roles("vip1");

    }
}
