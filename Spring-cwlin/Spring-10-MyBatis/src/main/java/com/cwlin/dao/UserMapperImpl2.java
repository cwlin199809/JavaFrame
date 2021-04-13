package com.cwlin.dao;

import com.cwlin.pojo.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

//真实对象，完成增删改查操作
public class UserMapperImpl2 extends SqlSessionDaoSupport implements UserMapper{
    @Override
    public List<User> selectUser() {
        return getSqlSession().getMapper(UserMapper.class).selectUser();
    }
}
