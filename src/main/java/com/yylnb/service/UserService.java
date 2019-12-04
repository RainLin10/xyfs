package com.yylnb.service;

import com.yylnb.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author RainLin
 * @date 2019/11/25 - 23:51
 */

public interface UserService {
    void authorizeLogin(User user);

    void updateUserInfo_member(User user);

    void updateUserInfo_admin(User user);

    User[] allUsers(String flag);

    void logout(HttpServletRequest request, HttpServletResponse response);

    void isSeller(User user);

}
