package com.kyle.springboot.mvc;

import com.kyle.springboot.service.IPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pub")
public class PublisherController {
    @Autowired
    private IPublisherService publisherService;

    @RequestMapping("/{id}")
    public String pubMeg(@PathVariable String id){
        return publisherService.publishMsg(id);
    }
}
