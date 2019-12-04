package com.yylnb.controller;

import com.yylnb.entity.User;
import com.yylnb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author RainLin
 * @date 2019/12/1 - 21:51
 */
@Controller
public class SellerController {
    @Autowired
    private UserService userService;

    @GetMapping("/apply")
    public String apply(@RequestParam("account") String account) {
        User user = new User();
        user.setAccount(account);
        //申请成为卖家
        user.setIsSeller(0);
        user.setIsApply(1);
        userService.isSeller(user);
        return "redirect:/";
    }
}
