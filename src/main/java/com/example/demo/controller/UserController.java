package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dao.UserDao;


import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;
    @Resource
    private UserDao userDao;

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

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

    @RequestMapping("/delete-id/{id}")
    public int deleteById(@PathVariable(value = "id") Integer id) {
        return userService.deleteById(id);
    }
    
   @RequestMapping("/select-count")
    public int selectCount() {
        return userDao.selectCount(null);
        }
    
    
    
    @RequestMapping("/set-cache-users")
    public String setCacheUsers() {
        List<User> allUser = userService.findAll();
        redisTemplate.opsForValue().set("allUser",allUser);
        return "ok";
    }
    @RequestMapping("/get-cache-users")
    public List<User> getCacheUsers() {
        List<User> allUser1 = (List<User>)redisTemplate.opsForValue().get("allUser");
        return allUser1;
    }
    @RequestMapping("/set-cache-user/{id}")
    public String setCacheUser(@PathVariable(value = "id") Integer id) {
        User user = userService.findUserById(id);
        redisTemplate.opsForValue().set("user"+id,user,10, TimeUnit.SECONDS);
        return "ok";
    }
    @RequestMapping("/get-cache-user/{id}")
    public User getCacheUser(@PathVariable(value = "id") Integer id) {
        User user = (User) redisTemplate.opsForValue().get("user"+id);
        return user;
    }



}
