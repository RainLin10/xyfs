package com.yylnb.service;

import com.yylnb.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author RainLin
 * @date 2019/11/25 - 23:51
 */

public interface UserService {
    User findByAccount(String account);
    void insertUser(User user);
    void updateUser(User user);

    void logout(HttpServletRequest request, HttpServletResponse response);
}
