package com.yylnb.service.impl;

import com.yylnb.entity.User;
import com.yylnb.mapper.UserMapper;
import com.yylnb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
        return userMapper.findByAccount(account);
    }

    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }


//    @Override
//    public void logout(HttpServletRequest request, HttpServletResponse response) {
//        request.getSession().invalidate();
//        System.out.println("用户注销");
//        Cookie[] cookies = request.getCookies();
//        if(cookies != null || cookies.length != 0){
//            for (Cookie cookie : cookies) {
//                if (cookie.getName().equals("token")){
//                    String token = cookie.getValue();
//                    redisTemplate.delete(token);
//                    cookie.setMaxAge(0);
//                    response.addCookie(cookie);
//                }
//            }
//        }
//    }
}
