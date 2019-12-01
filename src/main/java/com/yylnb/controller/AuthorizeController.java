package com.yylnb.controller;

import com.yylnb.dto.AccessToken;
import com.yylnb.dto.GithubUser;
import com.yylnb.entity.User;
import com.yylnb.provider.GithubProvider;
import com.yylnb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.util.UUID;

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
    @Autowired
    private UserService userService;


    //从配置文件中将Github需要的值注入进来
    @Value("${github.client.id}")
    private String Client_id;
    @Value("${github.client.secret}")
    private String Client_secret;
    @Value("${github.redirect.uri}")
    private String Redirect_uri;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletResponse response,
                           HttpSession session) throws Exception {

        //通过前端发送请求,此处接受回调函数,接受两个发送来的值
        //把数据封装以accessToken获取访问令牌
        AccessToken accessToken = new AccessToken();
        accessToken.setClient_id(Client_id);
        accessToken.setClient_secret(Client_secret);
        accessToken.setCode(code);
        accessToken.setRedirect_uri(Redirect_uri);
        accessToken.setState(state);

        //通过返回的token获取用户的数据                            调用获取访问令牌的方法 返回token
        GithubUser githubUser = githubProvider.githubUser(githubProvider.getAccessToken(accessToken));


        if (githubUser != null&&githubUser.getId()!=null) {
            //登录成功
            //拿到用户信息后封装自己的用户表用户
            User user = new User();
            user.setName(githubUser.getName());
            user.setAvatar_img(githubUser.getAvatar_url());
            user.setAccount(String.valueOf(githubUser.getId()));
            user.setBio(githubUser.getBio());

            user.setToken(UUID.randomUUID().toString());
            user.setCreate_time(System.currentTimeMillis());
            user.setLogin_time(System.currentTimeMillis());
            user.setLogin_times(1);
            InetAddress addr = InetAddress.getLocalHost();
            user.setLogin_ip(addr.getHostAddress());
            user.setIsVip(0);
            user.setSex(1);
            //加入或更新数据库 数据库无该账号，将上面的信息全部加入到数据库 有该账号就把除了授权的信息，其他的全部更新
            userService.authorizeLogin(user);
            //登录之后把token加入cookie 并设置过期时间
            Cookie cookie = new Cookie("token",  user.getToken());
            cookie.setMaxAge(60*60*24*7);
            response.addCookie(cookie);
            return "redirect:/";
        } else {
            return "redirect:/";
        }
    }
    /**
     * 用户退出登陆
     * 清除用户的本地cookie，及服务器端的session和redis中临时保存的用户数据
     */
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        userService.logout(request, response);
        return "redirect:/";}
}

