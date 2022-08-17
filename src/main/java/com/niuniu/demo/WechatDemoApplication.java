package com.niuniu.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WechatDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WechatDemoApplication.class, args);
    }

}
