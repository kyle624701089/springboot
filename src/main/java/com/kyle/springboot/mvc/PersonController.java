package com.kyle.springboot.mvc;

import com.kyle.springboot.entity.User;
import com.kyle.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User getOneUserById(@PathVariable("id")Integer id){
        return userService.findOneUserById(id);
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<User> getListUser(){
        return userService.findListUser();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public String updateUser(@PathVariable("id")Integer id, @RequestParam(value = "name")String name,@RequestParam(value = "age")Integer age){
        User user = userService.findOneUserById(id);
        if (user != null){
            user.setName(name);
            user.setAge(age);
            userService.updateUser(user);
            return "success";
        }else {
            return "failed";
        }
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public String addUser(@RequestParam(value = "name")String name,@RequestParam(value = "age")Integer age,@RequestParam(value = "sex")String sex,@RequestParam(value = "hobby")String hobby){
        try {
            User user = new User();
            user.setName(name);
            user.setAge(age);
            user.setSex(sex);
            user.setHobby(hobby);
            userService.insertUser(user);
        }catch (Exception e){
            return "failed";
        }
        return "success";
    }
}
