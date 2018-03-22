package com.kyle.springboot.dao;/**
 * @Author: kyle
 * @Description:
 * @Date: Created in 11:17 2018/3/22
 * @Modified By:
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 *
 *@author kyle
 *@create 2018 - 03 - 22 11:17
 */
@SpringBootApplication
public class SpringBootBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootBookApplication.class, args);
    }
}
