package com.cwlin.demo02;

//代理角色，在这里面增加日志的实现
public class UserServiceProxy implements UserService{
    private UserServiceImpl userService;

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public void insert() {
        log("insert");
        userService.insert();
    }

    @Override
    public void delete() {
        log("delete");
        userService.delete();
    }

    @Override
    public void update() {
        log("update");
        userService.update();
    }

    @Override
    public void select() {
        log("select");
        userService.select();
    }

    //日志方法
    public void log(String msg){
        System.out.println("[Debug] 使用了"+msg+"方法");
    }
}
