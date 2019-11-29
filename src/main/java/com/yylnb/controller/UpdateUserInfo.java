package com.yylnb.controller;

import com.yylnb.entity.User;
import com.yylnb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @author RainLin
 * @date 2019/11/29 - 14:44
 */

@Controller
public class UpdateUserInfo {

    @Autowired
    private UserService userService;


    @PostMapping("/updateUserInfo")
    public String updateUserInfo(
            @RequestParam("name") String name,
            @RequestParam("bio") String bio,
            @RequestParam("account") String account,
            @RequestParam("sex") Integer sex,
            HttpServletRequest request,
            Model model) {
        //后端数据格式检查 不合格返回错误信息
        if (name == null || Objects.equals(name, "") || name.length() > 10) {
            model.addAttribute("error", "昵称不能为空");
            return "member";
        }
        if (bio == null || Objects.equals(bio, "") || bio.length() > 20) {
            model.addAttribute("error", "签名不能为空");
            return "member";
        }
        if (sex == null) {
            model.addAttribute("error", "性别不能为空");
            return "member";
        }

        User user = new User();
        user.setName(name);
        user.setBio(bio);
        user.setAccount(account);

        user.setSex(sex);

        //更新
        userService.UpdateUserInfo(user);
        return "redirect:member";
    }
}
