package com.yylnb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan("com.yylnb.mapper")
@SpringBootApplication
@EnableScheduling
public class XyfsApplication {

    public static void main(String[] args) {
        SpringApplication.run(XyfsApplication.class, args);
    }

}
