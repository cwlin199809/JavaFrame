package com.cwlin.config;

import com.cwlin.pojo.User;
import com.cwlin.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

//自定义UserRealm
public class UserRealm extends AuthorizingRealm {
    @Autowired
    UserService userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权操作：doGetAuthorizationInfo");
        
        //初始化授权消息对象
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获取当前登录用户
        Subject subject = SecurityUtils.getSubject();
        //获取User对象
        User currentUser = (User) subject.getPrincipal();
        //设置当前用户的权限
        info.addStringPermission(currentUser.getPerms());

        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证操作：doGetAuthenticationInfo");

        //获取当前用户的数据令牌
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //连接真实数据库
        User user = userService.selectUserByName(token.getUsername());

        //判断用户名
        if(user == null){
            return null; //抛出 UnknownAccountException 异常
        }
        //判断密码（Shiro实现）
        return new SimpleAuthenticationInfo(user, user.getPwd(),"");
    }
}
