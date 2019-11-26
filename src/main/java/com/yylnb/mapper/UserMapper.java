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
    @Insert("insert into user(id,name,account,password,token,avatar_img,create_time,login_time,login_times,login_ip,tel) values(#{id},#{name},#{account},#{password},#{token},#{avatar_img},#{create_time},#{login_time},#{login_times},#{login_ip},#{tel})")
    void insertUser(User uesr);

    @Select("select * from user where account=#{account}")
    User findByAccount(String account);

    @Update("update user set name=#{name},password=#{password},token=#{token},avatar_img=#{avatar_img},login_time=#{login_time},login_times=login_times+1,login_ip=#{login_ip}")
    void updateUser(User user);

    @Select("select * from user where token=#{token}")
    User findByToken(@Param("token") String token);
}
