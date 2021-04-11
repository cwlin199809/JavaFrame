package com.cwlin.demo02;

public class Client {
    public static void main(String[] args) {
        //真实业务
        UserServiceImpl userService = new UserServiceImpl();
        //代理
        UserServiceProxy proxy = new UserServiceProxy();
        //使用代理类实现日志功能！
        proxy.setUserService(userService);
        //业务实现
        proxy.insert();
        proxy.delete();
        proxy.update();
        proxy.select();
    }
}
