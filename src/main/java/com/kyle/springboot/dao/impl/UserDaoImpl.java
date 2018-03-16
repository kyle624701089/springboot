package com.kyle.springboot.dao.impl;

import com.kyle.springboot.dao.UserDao;
import com.kyle.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void insertUser(User user) {
        jdbcTemplate.update("INSERT INTO user(ID,NAME,AGE,SEX,HOBBY) VALUES (?,?,?,?,?)",user.getId(),user.getName(),user.getAge(),user.getSex(),user.getHobby());
    }

    @Override
    public void delById(Integer id) {
        jdbcTemplate.update("DELETE FROM user WHERE ID=?",id);
    }

    @Override
    public void updateUser(User user) {
        jdbcTemplate.update("UPDATE user SET NAME = ?,AGE = ?,SEX = ?,HOBBY = ?",user.getName(),user.getAge(),user.getSex(),user.getHobby());
    }

    @Override
    public User findOneUserById(Integer id) {
        List<User> userList = jdbcTemplate.query("SELECT * FROM user where ID = ?", new Object[]{id}, new BeanPropertyRowMapper<>(User.class));
        if (userList != null && userList.size() > 0){
            return userList.get(0);
        }else {
            return null;
        }
    }

    @Override
    public List<User> findListUser() {
        List<User> userList = jdbcTemplate.query("SELECT * FROM user where ID = ?", new Object[]{}, new BeanPropertyRowMapper<>(User.class));
        if (userList != null && userList.size() > 0){
            return userList;
        }else {
            return null;
        }
    }
}
