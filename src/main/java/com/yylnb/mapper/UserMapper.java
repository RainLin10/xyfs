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
    @Insert("insert into user(name,account,password,token,avatar_img,create_time,login_time,login_times,login_ip,tel,bio) " +
            "values(#{name},#{account},#{password},#{token},#{avatar_img},#{create_time},#{login_time},#{login_times},#{login_ip},#{tel},#{bio})")
    void insertUser(User user);

    //根据账户找人
    @Select("select * from user where account=#{account}")
    User findByAccount(String account);

    //根据token找用户
    @Select("select * from user where token=#{token}")
    User findByToken(@Param("token") String token);

    //找所有人
    @Select("select * from user")
    User[] allUsers();

    //找申请卖家资格的人
    @Select("select * from user where isApply = 1&&isSeller=0")
    User[] allApply();

    //每次登录更新登录时间
    @Update("update user set login_time=#{login_time} where account=#{account}")
    void updateLoginTime(User user);

    //根据id更新token、登录时间、登录次数、登录ip
    @Update("update user set token=#{token},login_time=#{login_time},login_times=login_times+1,login_ip=#{login_ip} where account=#{account}")
    void updateUser_login(User user);

    //在个人信息页面发起请求更改个人信息
    @Update("update user set name=#{name},bio=#{bio},sex=#{sex} where account=#{account}")
    void updateUserInfo_member(User user);

    //在管理员页面发起请求更改个人信息
    @Update("update user set name=#{name},tel=#{tel},mail=#{mail},sex=#{sex},isSeller=#{isSeller} where account=#{account}")
    void updateUserInfo_admin(User user);

    //处理卖家申请的结果
    @Update("update user set isSeller=#{isSeller},isApply=#{isApply} where account=#{account}")
    void isSeller(User user);

}
