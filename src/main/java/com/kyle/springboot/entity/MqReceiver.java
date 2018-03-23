package com.kyle.springboot.entity;/**
 * @Author: kyle
 * @Description:
 * @Date: Created in 11:15 2018/3/23
 * @Modified By:
 */

import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 *RabbitMQ的接收者
 *@author kyle
 *@create 2018 - 03 - 23 11:15
 */
@Component
public class MqReceiver {
    private CountDownLatch latch = new CountDownLatch(1);
    public void receiveMessage(String message){
        System.out.println("接收者接收到信息："+message);
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
