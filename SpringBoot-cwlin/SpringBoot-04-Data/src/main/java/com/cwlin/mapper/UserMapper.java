package com.cwlin.mapper;

import com.cwlin.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

//这个注解表示这是MyBatis的Mapper类
@Mapper
@Repository
public interface UserMapper {
    //public static final int age =18; //公共静态常量

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
