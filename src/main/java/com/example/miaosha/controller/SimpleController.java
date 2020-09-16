package com.example.miaosha.controller;

import com.example.miaosha.daomai.Student;
import com.example.miaosha.daomai.User;
import com.example.miaosha.redis.RedisService;
import com.example.miaosha.redis.UserKey;
import com.example.miaosha.result.CodeMsg;
import com.example.miaosha.result.Result;
import com.example.miaosha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl;

import javax.annotation.Resource;

/**
 * @program: javamiaosha_2
 * @description
 * @author: 冷阳光
 **/
@Controller
@RequestMapping("/demo")
public class SimpleController {
    /*@Autowired
    UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;*/

    @RequestMapping("/thymeleaf")
    public String thymeleaf(Model model){
        model.addAttribute("name","yangguang");
        return "hello";
    }

    /*//1 res qpi 的json输出.2，页面
    @RequestMapping("/hello")
    @ResponseBody
    public Result<String> hello(){
        return Result.success("hello imooc");

    }*/
    /*@RequestMapping("/db/get")
    @ResponseBody
    public Result<Boolean> dbGet(){

        userService.tx();
        return Result.success(true);
        return new Result(0,"suceese","hello mooc");
    }*/
   /* @GetMapping("/redis/get")
    @ResponseBody
    public Result<String> redisGet(){

    }*/
   @Autowired
    RedisService redisService;
    @RequestMapping("/redis/set")
    @ResponseBody
    public Result<Boolean> redisSet() {
        User user  = new User();
        user.setId(1);
        user.setName("1111");
        redisService.set(UserKey.getById, ""+1, user);//UserKey:id1
        return Result.success(true);
    }

    @RequestMapping("/redis/get")
    @ResponseBody
    public Result<User> redisGet() {
        User  user  = redisService.get(UserKey.getById, ""+1, User.class);
        return Result.success(user);
    }

   /* @Autowired
    RedisTemplate redisTemplate;
    @PostMapping("/set")
    public void Set(@RequestBody Student student){

        *//*student.setId(2);
        student.setName("张三");
        student.setBirthday(1990);*//*
        redisTemplate.opsForValue().set("student",student);
    }*/

    Thread thread = new Thread();
    
}
