package com.kyle.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

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
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

    /**
     * 该方法可以看到springboot提供了哪些bean
     * @param ctx
     * @return
     *//*
	@Bean
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
}
