package com.kyle.springboot.config;

import com.kyle.springboot.entity.Receiver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import java.util.concurrent.CountDownLatch;

/**
 * 配置接收者步骤：
 *  1、创建连接工厂
 *  2、绑定消息监听者和要监听的方法
 *  3、注册订阅者
 *  4、用计数器来控制线程
 */
@Configuration
public class SubscriberConfig {

    @Bean
    public RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter){
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.addMessageListener(listenerAdapter,new PatternTopic("phone"));
        container.setConnectionFactory(connectionFactory);
        return container;
    }

    @Bean
    public MessageListenerAdapter listenerAdapter(Receiver receiver){
        return new MessageListenerAdapter(receiver,"receiveMessage");
    }

    @Bean
    public Receiver receiver(CountDownLatch latch){
        return new Receiver(latch);
    }

    @Bean
    public CountDownLatch latch(){
        return new CountDownLatch(1);
    }
}
