package com.yylnb.entity;

import lombok.Data;

/**
 * @author RainLin
 * @date 2019/11/30 - 17:22
 */
@Data
public class Commodity {
    private Integer userId;
    private String shop;
    private String title;
    private String info;
    private Integer price;
    private String img;
    private Integer volume;
    private Integer inventory;
}
