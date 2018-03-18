package com.kyle.springboot.service.impl;

import com.kyle.springboot.dao.UserMapper;
import com.kyle.springboot.entity.User;
import com.kyle.springboot.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
//@MapperScan(basePackages = {"com.kyle.springboot.dao"},sqlSessionFactoryRef = "sqlSessionFactory")
public class UserServiceImpl implements IUserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public void delById(Integer id) {
        userMapper.delById(id);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public User findOneUserById(Integer id) {
        return userMapper.findOneUserById(id);
    }

    @Override
    public List<User> findListUser() {
        return userMapper.findListUser();
    }
}
