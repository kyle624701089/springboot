package com.kyle.springboot;/**
 * @Author: kyle
 * @Description:
 * @Date: Created in 11:42 2018/3/20
 * @Modified By:
 */

import com.kyle.springboot.dao.RedisDao;
import com.kyle.springboot.dao.UserMapper;
import com.kyle.springboot.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 *@author kyle
 *@create 2018 - 03 - 20 11:42
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisApplicationTests {
    public static Logger logger= LoggerFactory.getLogger(SpringbootRedisApplicationTests.class);
    @Autowired
    private RedisDao redisDao;
//    @Resource
//    private UserMapper userMapper;
    @Autowired
    private StringRedisTemplate template;

    @Test
    public void testRedisDaoForKey(){
        redisDao.setKey("name","张三");
        redisDao.setKey("age","11");
        logger.info(redisDao.getValue("name"));
        logger.info(redisDao.getValue("age"));
    }

    @Test
    public void testRedisDaoForList(){
//        List<User> listUser = userMapper.findListUser();
//        ListOperations<String, String> listOperations = redisDao.setRedisList(listUser);
//        logger.info(listOperations.range("name",0L,5L).toString());
//        ListOperations<String, String> opsForList = template.opsForList();
//        List<String> pricess = opsForList.range("pricess", 0, 5);
//        logger.info(pricess.toString());
        redisDao.sendMessage();
        logger.info("redis消息发送了...");
    }
}
