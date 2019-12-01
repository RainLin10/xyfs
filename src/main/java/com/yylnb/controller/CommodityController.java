package com.yylnb.controller;

import com.yylnb.entity.Commodity;
import com.yylnb.mapper.CommodityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

/**
 * @author RainLin
 * @date 2019/11/30 - 17:10
 */
@Controller
public class CommodityController {

    @Autowired
    private CommodityMapper commodityMapper;

    //商品首页 暂时。。后面改为关键字搜索
    @GetMapping("/commodity")
    public String commodity(Model model, @RequestParam("search") String search) {
        Commodity commodity=new Commodity();
        commodity.setUserId(1);
        commodity.setShop("江南皮革厂");
        commodity.setTitle("皮革");
        commodity.setInfo("倒闭啦倒闭啦倒闭啦倒闭啦倒闭啦倒闭啦倒闭啦倒闭啦倒闭啦倒闭啦");
        commodity.setPrice(9999);
        commodity.setImg("https://avatars1.githubusercontent.com/u/50816755?");
        commodity.setVolume(9999);
        commodity.setInventory(9999);
        System.out.println(commodity);
        commodityMapper.addCommodity(commodity);
        List<Commodity> commodities = Arrays.asList(commodityMapper.allCommodities());
        System.out.println(commodities);
        model.addAttribute("commodities", commodities);
        return "commodity";
    }
}
