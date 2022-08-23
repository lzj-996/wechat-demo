package com.niuniu.demo;

import com.niuniu.demo.service.WechatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableScheduling
@Slf4j
public class WechatDemoApplication {

    public static WechatService wechatService;
    @Autowired
    private WechatService springWechatService;

    @PostConstruct
    public void init() {
        wechatService = springWechatService;
    }
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(WechatDemoApplication.class, args);
        try {
            wechatService.sendMpWechatMessage();
        }catch (Exception e){
            log.error("发送微信模板消息错误",e);
        }
        //启动执行完方法就关闭服务
        run.close();
    }

}
