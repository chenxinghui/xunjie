package com.example2.demo2.mapper;

import com.example2.demo2.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    List<User> sel(String id);
}
