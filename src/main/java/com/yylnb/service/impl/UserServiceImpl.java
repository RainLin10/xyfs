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

    @Override
    public User findByAccount(String account) {
        System.out.println("用户加入数据库");
        return userMapper.findByAccount(account);
    }

    @Override
    public void insertUser(User user) {
        //用账户在数据库寻找用户
        User findUser = userMapper.findByAccount(user.getAccount());
        //如果可以用ID找到该用户 代表已经注册了 找不到就注册
        if (findUser == null) {
            userMapper.insertUser(user);
            System.out.println("用户加入数据库");
        } else {
            userMapper.updateUser(user);
            System.out.println("用户已更新");
        }
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
        System.out.println("用户已更新");
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().invalidate();
        System.out.println("用户注销");
        Cookie[] cookies = request.getCookies();
        if(cookies != null || cookies.length != 0){
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")){
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
        }
    }



}
