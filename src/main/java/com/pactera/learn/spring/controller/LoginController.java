package com.pactera.learn.spring.controller;

import com.pactera.learn.spring.model.dto.UserDataDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {

    @RequestMapping(value = "goToLoginPage")
    public String toLoginPage(Model model) {
        List<String> usernames = new ArrayList<>();
        usernames.add("LiSa");
        usernames.add("Joey");
        usernames.add("Sam");
        model.addAttribute("usernames", usernames);
        model.addAttribute("pageTitle", "LoginPage");
//        return "login_page.html";
        return "login.html";
    }

    @PostMapping(value = "login")
    public String toLogin(@ModelAttribute UserDataDTO user, Model model) {
        System.out.println(user.getName());
        System.out.println(user.getEmail());
        model.addAttribute("username", user.getName());
        model.addAttribute("password", user.getEmail());
        return "login.html";
    }

}