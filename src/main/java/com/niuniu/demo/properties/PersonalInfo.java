package com.niuniu.demo.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author lzj
 * @date 2022/8/20 10:08
 * @description: 个人信息
 */
@ConfigurationProperties(prefix = "personal.info")
@Component
@Data
public class PersonalInfo {
    /**
     * 星座
     */
    private String constellation;

}
