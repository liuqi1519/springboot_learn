package com.pactera.learn.spring.controller;

import com.lk.api.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Api(tags = "用户登录模块")
@LKAType(value = "用户登录注册模块")
@RestController
@RequestMapping("user")
public class LKADemoController {

    @LKAMethod(value = "登录")
    //@LKAParam(names= {"name","pwd"},values= {"用户名","密码"})
    @LKARespose(names = {"code", "msg"}, values = {"状态码", "消息"})
    @PostMapping("login")
    public Map<String, Object> login(@LKAParam(name = "name", value = "用户名") String name, @LKAParam(name = "pwd", value = "密码") String pwd) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "登录成功，欢迎" + name + "光临本系统");
        return map;
    }
}