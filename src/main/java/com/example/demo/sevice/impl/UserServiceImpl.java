package com.example.demo.sevice.impl;


import com.example.demo.dao.UserDao;
import com.example.demo.pojo.User;
import com.example.demo.sevice.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User findUserById(Integer id) {
        User user = userDao.selectById(id);
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> users = userDao.selectList(null);
        return users;

    }

}