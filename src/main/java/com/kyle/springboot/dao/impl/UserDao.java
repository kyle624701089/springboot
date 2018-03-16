package com.kyle.springboot.dao.impl;

import com.kyle.springboot.entity.User;

import java.util.List;

public interface UserDao {
    void insertUser(User user);

    void delUserById(Integer id);

    void updateUser(User user);

    User getOneUserById(Integer id);

    List<User> getListUser();
}
