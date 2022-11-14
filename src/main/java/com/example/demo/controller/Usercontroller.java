package com.example.demo.controller;

import com.example.demo.pojo.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/consumer")
public class Usercontroller {

    @Autowired
    private RestTemplate restTemplate;

   @RequestMapping("/test-ok")
    public String testOk() {
        return "ok";
    }
    
    
    @RequestMapping("/find-provider1")
    public Long findUserByIdprovider1(){
        String url = "https://csqweb.azurewebsites.net/getCount";
        return restTemplate.getForObject(url, Long.class);
    }

    @RequestMapping("/find-provider2")
    public String findUserByIdprovider2(){
        String url = "https://csqweb.azurewebsites.net/findAll";
        return restTemplate.getForObject(url, String.class);
    }






}
