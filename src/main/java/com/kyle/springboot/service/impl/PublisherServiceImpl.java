package com.kyle.springboot.service.impl;

import com.kyle.springboot.service.IPublisherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class PublisherServiceImpl implements IPublisherService{
    private static final Logger logger = LoggerFactory.getLogger(PublisherServiceImpl.class);

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public String publishMsg(String id) {
        if ("1".equals(id)){
            redisTemplate.convertAndSend("phone","13000001111");
            logger.info("template发送了phone主题的信息....");
            return "success";
        }else {
            return "failed";
        }
    }
}
