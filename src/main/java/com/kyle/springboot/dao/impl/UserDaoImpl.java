package com.kyle.springboot.dao.impl;

import com.kyle.springboot.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author kyle
 * @create 2018 - 03 - 16 17:54
 */
@Repository
public class UserDaoImpl implements UserDao{
    @Override
    public void insertUser(User user) {

    }

    @Override
    public void delUserById(Integer id) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public User getOneUserById(Integer id) {
        return null;
    }

    @Override
    public List<User> getListUser() {
        return null;
    }
}
