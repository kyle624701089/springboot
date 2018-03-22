package com.kyle.springboot;

import com.kyle.springboot.entity.Receiver;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

/**
 * @Title:
 * @param:
 * @return:
 * @description:springboot启动类
 * @author:kyle
 * @date:2018/3/16 11:53
 * @throws:
 */
@SpringBootApplication
@EnableAutoConfiguration
public class SpringbootApplication {

	public static void main(String[] args) throws Exception{
        SpringApplication.run(SpringbootApplication.class, args);
//        StringRedisTemplate stringRedisTemplate = context.getBean(StringRedisTemplate.class);
//        CountDownLatch countDownLatch = context.getBean(CountDownLatch.class);
//        LOGGER.info("发送信息中....");
//        stringRedisTemplate.convertAndSend("chat","来自Redis的消息。");
//        countDownLatch.await();
//        System.exit(0);
    }

    /**
     * 该方法可以看到springboot提供了哪些bean
     * @param ctx
     * @return
     */
	/*@Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx){
        return args -> {
            System.out.println("Let's inspect the beans provided by Spring Boot:");
            String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanDefinitionNames);
            for (String beanName:beanDefinitionNames) {
                System.out.println(beanName);
            }
        };
    }*/

    /**
     * @author: kyle
     * @date: 2018/3/22 10:03
     * @description: 注入消息接受者
     * @param: [latch]
     * @return: com.kyle.springboot.entity.Receiver
     * @throws:
     */
    /*@Bean
    Receiver receiver(CountDownLatch latch) {
        return new Receiver(latch);
    }

    *//**
     * @author: kyle
     * @date: 2018/3/22 10:41
     * @description: 设置一个1的计数器
     * @param: []
     * @return: java.util.concurrent.CountDownLatch
     * @throws:
     *//*
    @Bean
    CountDownLatch latch() {
        return new CountDownLatch(1);
    }

    *//**
     * @author: kyle
     * @date: 2018/3/22 10:43
     * @description:注入一个template
     * @param: [connectionFactory]
     * @return: org.springframework.data.redis.core.StringRedisTemplate
     * @throws:
     *//*
    @Bean
    StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
        return new StringRedisTemplate(connectionFactory);
    }

    *//**
     * @author: kyle
     * @date: 2018/3/22 10:44
     * @description:注入一个加载了redis连接工厂和消息监听器适配器的redis消息监听容器
     * @param: [connectionFactory, listenerAdapter]
     * @return: org.springframework.data.redis.listener.RedisMessageListenerContainer
     * @throws:
     *//*
    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        //指定监听主题为chat的消息
        container.addMessageListener(listenerAdapter, new PatternTopic("chat"));
        return container;
    }

    *//**
     * @author: kyle
     * @date: 2018/3/22 10:45
     * @description:注入一个监听器适配器,并监听receiveMessage方法
     * @param: [receiver]
     * @return: org.springframework.data.redis.listener.adapter.MessageListenerAdapter
     * @throws:
     *//*
    @Bean
    MessageListenerAdapter listenerAdapter(Receiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }*/

}
