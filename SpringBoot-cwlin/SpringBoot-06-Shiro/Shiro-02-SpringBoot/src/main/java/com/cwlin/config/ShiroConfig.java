package com.cwlin.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    //使用自定义UserRealm类，创建Realm对象
    @Bean(name="Realm")
    public UserRealm getUserRealm(){
        return new UserRealm();
    }

    //创建DefaultWebSecurityManager对象，并关联Realm对象
    @Bean(name="SecurityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(
            @Qualifier("Realm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联Realm对象
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    //创建ShiroFilterFactoryBean对象，关联SecurityManager对象
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(
            @Qualifier("SecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //关联SecurityManager对象
        bean.setSecurityManager(defaultWebSecurityManager);

        //添加Shiro的内置过滤器
        Map<String, String> filterMap = new LinkedHashMap<>();
        //权限授权，访问url需要权限，没有授权会跳转到为授权页面
        filterMap.put("/user/insert", "perms[user:insert]");
        filterMap.put("/user/update", "perms[user:update]");
        //这里支持使用通配符
        filterMap.put("/user/*","authc");
        bean.setFilterChainDefinitionMap(filterMap);

        //设置登录请求页面
        bean.setLoginUrl("/toLogin");
        //设置未授权请求页面
        bean.setUnauthorizedUrl("/unauthorized");

        return bean;
    }

    //配置ShiroDialect，用于整合Shiro-Thymeleaf
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }
}
