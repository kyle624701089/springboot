package com.kyle.springboot.mvc;

import com.kyle.springboot.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 通过EnableConfigurationProperties注解让该类可以注入Person类
 * @author kyle
 * @create 2018 - 03 - 16 14:24
 */
@RestController
@EnableConfigurationProperties({Person.class})
public class PersonController {
    /**
     * 使用${}的方式读取application.yml配置文件中的信息，springboot会默认读取application.yml文件配置
     */

    @Value("${my.name}")
    private String name;
    @Value("${my.age}")
    private Integer age;
    @Value("${my.sex}")
    private String male;

    @Autowired
    private Person person;

    @RequestMapping("/getPerson")
    public String getUser() {
//        return name+":"+age+":"+male;
        return person.toString();
    }
}
