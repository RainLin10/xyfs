package com.yylnb.service;

import com.yylnb.entity.User;

/**
 * @author RainLin
 * @date 2019/11/25 - 23:51
 */

public interface UserService {
    User findByAccount(String account);
    void insertUser(User user);
}
