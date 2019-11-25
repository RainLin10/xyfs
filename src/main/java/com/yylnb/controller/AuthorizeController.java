package com.yylnb.controller;

import com.yylnb.dto.AccessToken;
import com.yylnb.dto.GithubUser;
import com.yylnb.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author RainLin
 * @date 2019/11/25 - 17:16
 */

/**
 * 此为github授权登录
 */
@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state) {
        //通过前端发送请求,此处接受回调函数,接受两个发送来的值
        //把数据封装以accessToken获取访问令牌
        AccessToken accessToken = new AccessToken();
        accessToken.setClient_id("Iv1.b66da60546dd747a");
        accessToken.setClient_secret("9bcb1609e3fcf32b645f4136e8def20a7b2a1bb6");
        accessToken.setCode(code);
        accessToken.setRedirect_uri("http://localhost:8080/callback");
        accessToken.setState(state);
        //调用获取访问令牌的方法 返回token
        String token = githubProvider.getAccessToken(accessToken);
        //通过返回的token获取用户的数据
        GithubUser user = githubProvider.githubUser(token);
        System.out.println(user);
        return "index";
    }
}
