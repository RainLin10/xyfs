package com.yylnb.dto;

import lombok.Data;

/**
 * @author RainLin
 * @date 2019/11/25 - 17:46
 */
@Data
public class GithubUser {
    private Long id;
    private String name;
    //描述
    private String bio;
    //github头像
    private String avatar_url;

    @Override
    public String toString() {
        return "GithubUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bio='" + bio + '\'' +
                '}';
    }
}
