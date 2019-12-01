package com.yylnb.mapper;

import com.yylnb.entity.Commodity;
import com.yylnb.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author RainLin
 * @date 2019/11/30 - 17:26
 */
@Mapper
@Component
public interface CommodityMapper {
    @Select("select * from commodity")
    Commodity[] allCommodities();

//    @Insert("insert into commodity(userId,shop,title,info,price,img,volume,inventory)
//    values(#{userId},#{shop},#{title},#{info},#{price},#{img},#{volume},#{inventory})")

    @Insert("insert into commodity(userId,shop,title,info,price,img,volume,inventory) " +
            "values(#{userId},#{shop},#{title},#{info},#{price},#{img},#{volume},#{inventory})")
    void addCommodity(Commodity commodity);
}
