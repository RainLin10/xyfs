package com.yylnb.mapper;

import com.yylnb.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

/**
 * @author RainLin
 * @date 2019/11/25 - 23:02
 */
@Mapper
@Component
public interface UserMapper {
    @Insert("insert into user(name,account,password,token,avatar_img,create_time,login_time,login_times,login_ip,tel,bio,isVip) values(#{name},#{account},#{password},#{token},#{avatar_img},#{create_time},#{login_time},#{login_times},#{login_ip},#{tel}),#{bio},#{isVip}")
    void insertUser(User user);

    @Select("select * from user where account=#{account}")
    User findByAccount(String account);

    //根据id更新token、登录时间、登录次数、登录ip
    @Update("update user set token=#{token},login_time=#{login_time},login_times=login_times+1,login_ip=#{login_ip} where account=#{account}")
    void updateUser_login(User user);
    //在个人信息页面发起请求更改个人信息
    @Update("update user set name=#{name},bio=#{bio},sex=#{sex} where account=#{account}")
    void updateUserInfo(User user);

    @Select("select * from user where token=#{token}")
    User findByToken(@Param("token") String token);
}
