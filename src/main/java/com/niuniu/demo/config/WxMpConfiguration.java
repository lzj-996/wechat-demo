package com.niuniu.demo.config;

import com.niuniu.demo.handler.MsgHandler;
import com.niuniu.demo.properties.WechatConfigProperties;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lzj
 * @date 2022/8/15 10:16
 * @description:
 */
@AllArgsConstructor
@Configuration
@Slf4j
public class WxMpConfiguration {

    @Autowired
    private WechatConfigProperties wechatConfigProperties;

    @Autowired
    private MsgHandler msgHandler;


    @Bean
    public WxMpService wxMpService() {
        WxMpDefaultConfigImpl config = new WxMpDefaultConfigImpl();
        // 设置微信公众号的appid
        config.setAppId(wechatConfigProperties.getAppId());
        // 设置微信公众号的app corpSecret
        config.setSecret(wechatConfigProperties.getAppSecret());
        config.setToken(wechatConfigProperties.getToken());
        WxMpService wxService = new WxMpServiceImpl();
        wxService.setWxMpConfigStorage(config);
        return wxService;
    }

    @Bean
    public WxMpMessageRouter messageRouter(WxMpService wxMpService) {
        final WxMpMessageRouter newRouter = new WxMpMessageRouter(wxMpService);
        newRouter.rule().async(false).handler(this.msgHandler).end();
        return newRouter;
    }


}
