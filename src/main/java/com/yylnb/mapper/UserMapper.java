package com.yylnb.mapper;

import com.yylnb.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author RainLin
 * @date 2019/11/25 - 23:02
 */
@Mapper
public interface UserMapper {
    @Insert("insert into user(id,name,account,password,token,avatar_img,create_time,login_time,count,login_ip,tel) values(#{id},#{name},#{account},#{password},#{token},#{avatar_img},#{create_time},#{login_time},#{count},#{login_ip},#{tel})")
    void insertUser(User uesr);

    @Select("select * from user where account=#{account}")
    User findByAccount(String account);
}
