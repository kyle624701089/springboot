package com.kyle.springboot.mvc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * helloController
 *
 * @author kyle
 * @create 2018 - 03 - 16 9:43
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String hello(){
        return "Greetings from Spring Boot!";
    }
}
