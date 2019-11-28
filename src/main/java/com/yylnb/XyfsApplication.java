package com.yylnb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class XyfsApplication {
    public static void main(String[] args) {
        SpringApplication.run(XyfsApplication.class, args);
    }


}
