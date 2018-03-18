package com.kyle.springboot.dao;

import com.kyle.springboot.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface UserMapper {
    @Insert("insert into user(name,age,sex,hobby) values(#{name},#{age},#{sex},#{hobby})")
    void insertUser(User user);

    @Delete("delete from user where id = #{id}")
    void delById(@Param("id") Integer id);

    @Update("update user set name = #{name},age = #{age},sex = #{sex},hobby = #{hobby}")
    void updateUser(User user);

    @Select("select * from user where id = #{id}")
    User findOneUserById(@Param("id")Integer id);

    @Select("select * from user")
    List<User> findListUser();
}
