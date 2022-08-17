package com.niuniu.demo.properties;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author lzj
 * @date 2022/8/16 12:01
 * @description:
 */
@Data
public class WechatTemplate {
    private String templateId;

    private Boolean allSend;

    private List<String> filterOpenIds;

    private Map<String, Object> parameter;
}
