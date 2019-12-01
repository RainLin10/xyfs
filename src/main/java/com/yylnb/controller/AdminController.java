package com.yylnb.controller;

import com.yylnb.entity.User;
import com.yylnb.mapper.UserMapper;
import com.yylnb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author RainLin
 * @date 2019/11/30 - 15:18
 */
@Controller
public class AdminController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/admin")
    public String admin(Model model, @RequestParam("id") Integer id) {
        if (id.equals(2)) {
            List<User> users = Arrays.asList(userMapper.allUsers());
            model.addAttribute("users", users);
            return "admin";
        }
        return "redirect:/";
    }
}
