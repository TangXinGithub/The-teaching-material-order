package com.example.controller;

import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.service.UserService;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping("/findAll")
    @ResponseBody
    public List<User> findAll(){ //return userService.findAll();
        List<User> users = userService.findAll();
        return users;
    }

}
