package com.yylnb.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author RainLin
 * @date 2019/11/25 - 20:46
 */
@Data
public class User {
    //表ID
    private Integer id;
    //昵称
    private String name;
    //账户/邮箱
    private String account;
    //密码
    private  String password;
    //电话号码
    private Integer tel;
    //token
    private String token;
    //头像
    private String avatar_img;
    //创建时间
    private Long create_time;
    //登录时间
    private Long login_time;
    //登录ip
    private String login_ip;
    //登录次数
    private Integer login_times;

}
