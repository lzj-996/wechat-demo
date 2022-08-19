package com.niuniu.demo.controller;

import com.niuniu.demo.service.WechatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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
    public Map<String, String> sendWechatMessage() {
        Map<String, String> result = new HashMap<>();
        try {
            wechatService.sendMpWechatMessage();
            result.put("message", "发送成功");
        } catch (Exception e) {
            result.put("message", "发送失败：" + e.getMessage());
        }
        return result;
    }
}
