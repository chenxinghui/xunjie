package com.example2.demo2.controller;

import com.example2.demo2.entity.User;
import com.example2.demo2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class UserController {

    @Autowired
    UserService userService;
    @RequestMapping(value = "/user")
    public List<User> getUser(String id){
        return userService.sel(id);
    }
}
