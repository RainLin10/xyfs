package com.yylnb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author RainLin
 * @date 2019/11/24 - 19:47
 */
@Controller
public class LoginController {
    //    @RequestMapping(value = "/Login",method = RequestMethod.POST)
    @PostMapping("/Login")
    public String Login(@RequestParam("account") String account,
                        @RequestParam("passWord") String passWord,
                        Map<String,Object> map,
                        HttpSession session) {
        if (!StringUtils.isEmpty(account) && "123".equals(passWord)) {
            session.setAttribute("account",account);
            return "redirect:/index.html";
        }
        map.put("msg","用户名密码错误!");
        return "login";
    }
}
