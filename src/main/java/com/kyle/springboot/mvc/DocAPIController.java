package com.kyle.springboot.mvc;/**
 * @Author: kyle
 * @Description: 生成doc API
 * @Date: Created in 14:37 2018/3/20
 * @Modified By:
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

/**
 *
 *@author kyle
 *@create 2018 - 03 - 20 14:37
 */
@RestController
@RequestMapping("/api")
public class DocAPIController {

    @GetMapping("/greeting")
    public Map<String,String> greeting(){
        return Collections.singletonMap("Message","Hello World!");
    }
}
