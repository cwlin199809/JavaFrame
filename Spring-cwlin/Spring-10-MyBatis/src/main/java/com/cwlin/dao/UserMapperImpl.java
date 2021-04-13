package com.cwlin.dao;

import com.cwlin.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

//真实对象，完成增删改查操作
public class UserMapperImpl implements UserMapper{
    //我们所有的操作，原来都使用sqlSession来执行，现在都使用SqlSessionTemplate
    private SqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public List<User> selectUser() {
        UserMapper mapper = sqlSessionTemplate.getMapper(UserMapper.class);
        return mapper.selectUser();
    }
}
