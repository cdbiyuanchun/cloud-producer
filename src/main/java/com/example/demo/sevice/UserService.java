package com.example.demo.sevice;

import com.example.demo.pojo.User;

import java.util.List;


public interface UserService {
    /**
     * 根据id进行查询
     */
    User findUserById(Integer id);
    List<User> findAll();
}

