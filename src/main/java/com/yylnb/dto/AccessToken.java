package com.yylnb.dto;

import lombok.Data;

/**
 * @author RainLin
 * @date 2019/11/25 - 17:23
 */
@Data
public class AccessToken {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;

}
