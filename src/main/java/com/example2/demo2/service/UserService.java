package com.example2.demo2.service;

import com.example2.demo2.entity.User;
import com.example2.demo2.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private static final String CACHE_KEY = "user";

    private static final String DEMO_CACHE_NAME = "users";

    @Autowired
    UserMapper userMapper;


    @Cacheable(value = DEMO_CACHE_NAME,key = "user_")
    public List<User> sel(String id){
        List<User> userList = userMapper.sel(id);
        for (User user : userList){
            System.out.println("输出是： =="+user.getName());
        }
        return userList;
    }
}
