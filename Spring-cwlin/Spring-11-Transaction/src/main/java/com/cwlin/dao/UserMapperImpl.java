package com.cwlin.dao;

import com.cwlin.pojo.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

//真实对象，完成增删改查操作
public class UserMapperImpl extends SqlSessionDaoSupport implements UserMapper{
    @Override
    public List<User> selectUser() {
        User user = new User(6, "小林", "741852");
        UserMapper mapper = getSqlSession().getMapper(UserMapper.class);
        mapper.insertUser(user);
        mapper.deleteUser(6);
        return mapper.selectUser();
    }

    @Override
    public int insertUser(User user) {
        return getSqlSession().getMapper(UserMapper.class).insertUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return getSqlSession().getMapper(UserMapper.class).deleteUser(id);
    }
}
