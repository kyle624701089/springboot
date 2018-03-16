package com.kyle.springboot.mvc;

import com.kyle.springboot.entity.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kyle
 * @create 2018 - 03 - 16 15:13
 */
@RestController
@EnableConfigurationProperties({Dog.class})
public class DogController {
    @Autowired
    private Dog dog;

    @RequestMapping(value = "/getDog",produces = "text/json;charset=UTF-8")
    public String getDog(){
        return dog.toString();
    }
}
