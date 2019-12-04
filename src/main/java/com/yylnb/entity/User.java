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
    //账户
    private String account;
    //电话号码
    private Long tel;
    //邮箱
    private String mail;
    //密码
    private String password;
    //性别
    private Integer sex;
    //签名
    private String bio;
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
    //是否会员
    private Integer isVip;
    //是否卖家
    private Integer isSeller;
    //是否申请卖家
    private Integer isApply;
}
