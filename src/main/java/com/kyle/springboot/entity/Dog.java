package com.kyle.springboot.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 除了springboot的核心配置文件外，其他配置文件只能用properties文件类型
 * 使用PropertySource注解加载配置文件路径
 * @author kyle
 * @create 2018 - 03 - 16 15:08
 */
@Configuration
@PropertySource(value = "classpath:dog.properties")
@ConfigurationProperties(prefix = "dog")
public class Dog {
    private String name;
    private Integer age;
    private String type;
    private String hobby;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", type='" + type + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
