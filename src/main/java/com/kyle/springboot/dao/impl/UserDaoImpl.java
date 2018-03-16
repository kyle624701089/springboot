package com.kyle.springboot.dao.impl;

import com.kyle.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author kyle
 * @create 2018 - 03 - 16 17:54
 */
@Repository
public class UserDaoImpl implements UserDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insertUser(User user) {
        jdbcTemplate.update("INSERT INTO USER(id,NAME,age,sex,hobby) VALUES (?,?,?,?,?)",user.getId(),user.getName(),user.getAge(),user.getSex(),user.getHobby());
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
