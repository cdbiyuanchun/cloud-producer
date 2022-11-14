package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/find/{id}")
    public User findUserById(@PathVariable(value = "id")Integer id){
        User user = userService.findUserById(id);
        return user;
    }


    @RequestMapping("/find-user")
    public List<User> findAll() {
        List<User> all = userService.findAll();
        return all;
    }

    @RequestMapping("/delete-id")
    public int findAll(@PathVariable(value = "id") Integer id) {
        return userService.deleteById(id);
    }






}
