package com.cwlin.service;

import com.cwlin.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserService {
    @Select("select * from user where name = #{name}")
    User selectUserByName(String name);

    @Select("select * from user")
    List<User> selectUserList();
    @Select("select * from user where id = #{id}")
    User selectUserById(int id);
    @Insert("insert into User (id,name,pwd) values (#{id},#{name},#{pwd})")
    int insertUser(User user);
    @Update("update user set name=#{name},pwd=#{pwd} where id=#{id}")
    int updateUser(User user);
    @Delete("delete from user where id = #{id}")
    int deleteUser(int id);
}
