package com.kyle.springboot.dao;

import com.kyle.springboot.entity.User;

import java.util.List;

public interface UserDao {
    void insertUser(User user);
    void delById(Integer id);
    void updateUser(User user);
    User findOneUserById(Integer id);
    List<User> findListUser();
}
