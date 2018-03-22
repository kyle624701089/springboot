package com.kyle.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

//@Configuration
public class PublisherConfig {
    /**
     * 作为redis的发布者
     * @param factory
     * @return
     */
    @Bean
    public StringRedisTemplate template(RedisConnectionFactory factory){
        return new StringRedisTemplate(factory);
    }
}
