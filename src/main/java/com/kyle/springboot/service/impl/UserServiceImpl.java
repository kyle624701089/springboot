package com.kyle.springboot.service.impl;

import com.kyle.springboot.dao.UserDao;
import com.kyle.springboot.entity.User;
import com.kyle.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserDao userDao;
    @Override
    public void insertUser(User user) {
        userDao.insertUser(user);
    }

    @Override
    public void delById(Integer id) {
        userDao.delById(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public User findOneUserById(Integer id) {
        return userDao.findOneUserById(id);
    }

    @Override
    public List<User> findListUser() {
        return userDao.findListUser();
    }
}
