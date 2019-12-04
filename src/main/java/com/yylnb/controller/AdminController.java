package com.yylnb.controller;

import com.yylnb.entity.User;
import com.yylnb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

/**
 * @author RainLin
 * @date 2019/11/30 - 15:18
 */
@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    //进入管理员页面 查询所有人
    @GetMapping("/admin")
    public String admin(Model model) {
        List<User> users = Arrays.asList(userService.allUsers("all"));
        model.addAttribute("users", users);
        model.addAttribute("flag", "all");
        return "admin/admin";
    }

    //查询正在申请商家的人
    @GetMapping("/admin/apply")
    public String apply(Model model) {
        List<User> users = Arrays.asList(userService.allUsers("apply"));
        model.addAttribute("users", users);
        model.addAttribute("flag", "apply");
        return "admin/admin";
    }

    //处理审核结果
    @GetMapping("/admin/apply/result")
    public String result(@RequestParam("result") String result,
                         @RequestParam("account") String account) {
        User user = new User();
        user.setAccount(account);
        //根据不同的结果处理
        if (result.equals("adopt")) {
            //通过卖家审核 将isSeller设置为1 将isApply设置为0防止再次出现在申请列表
            user.setIsSeller(1);
            user.setIsApply(0);
        } else if (result.equals("refuse")) {
            //退回 全部设置为0
            user.setIsSeller(0);
            user.setIsApply(0);
        }
        userService.isSeller(user);
        return "redirect:/admin";
    }

    //在管理员页面修改用户个人信息
    @PostMapping("/admin/modify")
    public String modify(@RequestParam("name") String name,
                         @RequestParam("tel") Long tel,
                         @RequestParam("mail") String mail,
                         @RequestParam("isSeller") Integer isSeller,
                         @RequestParam("sex") Integer sex,
                         @RequestParam("account") String account) {
        User user = new User();
        user.setAccount(account);
        user.setName(name);
        user.setTel(tel);
        user.setMail(mail);
        user.setIsSeller(isSeller);
        user.setSex(sex);
        if (user.getMail().equals("")) {
            user.setMail(null);
        }
        userService.updateUserInfo_admin(user);
        return "redirect:/admin";
    }


}
