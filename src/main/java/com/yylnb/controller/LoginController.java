package com.yylnb.controller;

import com.yylnb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author RainLin
 * @date 2019/11/28 - 19:23
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String register(){

        return  null;
    }

    @GetMapping("/login")
    public String login(){

        return  null;
    }
}
