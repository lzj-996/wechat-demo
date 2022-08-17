package com.niuniu.demo.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author lzj
 * @date 2022/8/16 11:53
 * @description:
 */
@ConfigurationProperties(prefix = "wechat.config")
@Component
@Data
public class WechatConfigProperties {
    private String appId;

    private String appSecret;

    private Map<String, WechatTemplate> template;
}
