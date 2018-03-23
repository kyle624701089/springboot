package com.kyle.springboot;/**
 * @Author: kyle
 * @Description:
 * @Date: Created in 11:23 2018/3/23
 * @Modified By:
 */

import com.kyle.springboot.entity.MqReceiver;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;

/**
 *一个消息监听器，声明quene队列和exchange并绑定，还要个发送者
 *@author kyle
 *@create 2018 - 03 - 23 11:23
 */
@SpringBootApplication
public class SpringBootRabbitMQApplication {

    final static String queueName = "spring-boot";

    @Bean
    Queue queue(){
        return new Queue(queueName,false);
    }

    @Bean
    TopicExchange exchange(){
        return new TopicExchange("spring-boot-exchange");
    }

    @Bean
    Binding binding(Queue queue,TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(queueName);
    }

    @Bean
    public SimpleMessageListenerContainer container(MessageListenerAdapter listenerAdapter, ConnectionFactory factory){
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(factory);
        container.setQueueNames(queueName);
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(MqReceiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringBootRabbitMQApplication.class, args);
    }

}
