package com.pactera.learn.spring.controller;

import com.pactera.learn.spring.model.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {
    @PostMapping("add")
    public User addUser(@RequestBody User user) {
        // 。。。业务逻辑。。。
        System.out.println(user.getName());
        System.out.println(user.getEmail());
        return user;
    }
}