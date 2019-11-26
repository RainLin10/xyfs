package com.yylnb.interceptor;

import com.yylnb.entity.User;
import com.yylnb.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author RainLin
 * @date 2019/11/24 - 20:54
 */

/**
 * 登录检查
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    UserMapper userMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("进入拦截器");
        //找cookie
        Cookie[] cookies = request.getCookies();
        System.out.println("所有的"+cookies);
        //循环名为token的cookie
        for (Cookie cookie : cookies) {
            if ("token".equals(cookie.getName())) {
                System.out.println("找到的"+cookie);
                String token = cookie.getValue();
                System.out.println("token"+token);
                //如果找到就用token去数据库找 然后把user注入到session
                User user = userMapper.findByToken(token);
                System.out.println(user);
                if (user != null) {
                    request.getSession().setAttribute("user", user);
                }
                break;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
