package com.cwlin.demo02;

//真实对象，完成增删改查操作的人
public class UserServiceImpl implements UserService{
    @Override
    public void insert() {
        System.out.println("插入一个用户");
    }

    @Override
    public void delete() {
        System.out.println("删除一个用户");
    }

    @Override
    public void update() {
        System.out.println("修改一个用户");
    }

    @Override
    public void select() {
        System.out.println("查询一个用户");
    }
}
