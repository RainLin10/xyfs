package com.yylnb.service.impl;

import com.yylnb.entity.User;
import com.yylnb.mapper.UserMapper;
import com.yylnb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author RainLin
 * @date 2019/11/25 - 23:51
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;



    //授权登录，首先用账户在数据库找是否存在，无就加入，有就除去授权的信息将其他的信息更新,除去授权信息是为了保证本站信息优先性
    @Override
    public void authorizeLogin(User user) {
        //用账户在数据库寻找用户
        User findUser = userMapper.findByAccount(user.getAccount());
        //如果可以用ID找到该用户 代表已经注册了 找不到就注册
        if (findUser == null) {

            userMapper.insertUser(user);
            System.out.println("用户加入数据库");
        } else {
            userMapper.updateUser_login(user);
            System.out.println("用户已更新");
        }
    }

    //在个人信息页面更新个人信息
    @Override
    public void UpdateUserInfo(User user) {
        userMapper.updateUserInfo(user);
    }

    //注销
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        //删除session
        request.getSession().invalidate();
        System.out.println("用户注销");
        //删除cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null || cookies.length != 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
        }
    }


}
