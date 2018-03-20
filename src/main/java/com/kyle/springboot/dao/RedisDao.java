package com.kyle.springboot.dao;/**
 * @Author: kyle
 * @Description:
 * @Date: Created in 11:34 2018/3/20
 * @Modified By:
 */

import com.kyle.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *RedisDao
 *@author kyle
 *@create 2018 - 03 - 20 11:34
 */
@Repository
public class RedisDao {

    @Autowired
    private StringRedisTemplate template;

    /**
     * @author: kyle
     * @date: 2018/3/20 11:49
     * @description: 使用redis存入键值对
     * @param: [key, value]
     * @return: void
     * @throws:
     */
    public void setKey(String key,String value){
        ValueOperations<String, String> opsForValue = template.opsForValue();
        opsForValue.set(key, value,1L, TimeUnit.MINUTES);
    }

    /**
     * @author: kyle
     * @date: 2018/3/20 11:49
     * @description: redis根据key取出value
     * @param: [key]
     * @return: java.lang.String
     * @throws:
     */
    public String getValue(String key){
        ValueOperations<String, String> opsForValue = template.opsForValue();
        return opsForValue.get(key);
    }

    /**
     * @author: kyle
     * @date: 2018/3/20 14:08
     * @description: 存储key为name的redisList
     * @param: [userList]
     * @return: org.springframework.data.redis.core.ListOperations<java.lang.String,java.lang.String>
     * @throws:
     */
    public ListOperations<String,String> setRedisList(List<User> userList){
        ListOperations<String, String> opsForList = template.opsForList();
        if (userList != null && userList.size() > 0){
            for (User user:userList) {
                opsForList.rightPush("name",user.getName());
            }
        }
        return opsForList;
    }
}
