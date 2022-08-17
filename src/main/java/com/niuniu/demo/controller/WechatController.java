package com.niuniu.demo.controller;

import com.niuniu.demo.service.WechatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lzj
 * @date 2022/8/16 14:18
 * @description:
 */
@RestController
@RequestMapping("wechat")
@Slf4j
public class WechatController {

    @Autowired
    public WechatService wechatService;


    @GetMapping("sendMessage")
    public void sendWechatMessage() {
        wechatService.sendMpWechatMessage();
    }
}
