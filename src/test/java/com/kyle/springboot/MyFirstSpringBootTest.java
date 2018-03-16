package com.kyle.springboot;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * 第一个springboot测试类
 *
 * @author kyle
 * @create 2018 - 03 - 16 14:07
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MyFirstSpringBootTest {
    /**
     * 通过LocalServerPort标签获得springboot启动时的端口号
     */
    @LocalServerPort
    private int port;
    private URL base;
    @Autowired
    private TestRestTemplate testRestTemplate;
    @Before
    public void setUrl() throws Exception{
        this.base = new URL("http://localhost:"+port+"/");
    }
    @Test
    public void hello() throws Exception{
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity(base.toString(), String.class);
        assertThat(responseEntity.getBody(),equalTo("Greetings from Spring Boot!"));
    }
}
