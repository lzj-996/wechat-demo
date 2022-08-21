package com.niuniu.demo.controller;

import com.niuniu.demo.service.WechatService;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    @Autowired
    public WxMpService wxMpService;

    @Autowired
    private  WxMpMessageRouter wxMpMessageRouter;

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

    @GetMapping("msg")
    public String validToken(HttpServletRequest request) {
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        boolean b = wxMpService.checkSignature(timestamp, nonce, signature);
        if (b){
            return echostr;
        }else {
            return null;
        }
    }

    @PostMapping("msg")
    public String message(@RequestBody String requestBody,
                          @RequestParam("signature") String signature,
                          @RequestParam("timestamp") String timestamp,
                          @RequestParam("nonce") String nonce,
                          @RequestParam("openid") String openid,
                          @RequestParam(name = "encrypt_type", required = false) String encType,
                          @RequestParam(name = "msg_signature", required = false) String msgSignature) {
        log.info("\n接收微信请求：[openid=[{}], [signature=[{}], encType=[{}], msgSignature=[{}],"
                        + " timestamp=[{}], nonce=[{}], requestBody=[\n{}\n] ",
                openid, signature, encType, msgSignature, timestamp, nonce, requestBody);
        if (!wxMpService.checkSignature(timestamp, nonce, signature)) {
            throw new IllegalArgumentException("非法请求，可能属于伪造的请求！");
        }
        String out = acceptWxMessage(timestamp, nonce, msgSignature, encType, requestBody);
        log.debug("\n组装回复信息：{}", out);
        return out;
    }

    private String acceptWxMessage(String timestamp, String nonce, String msgSignature, String encType, String requestBody) {
        String out = null;
        if (encType == null) {
            // 明文传输的消息
            WxMpXmlMessage inMessage = WxMpXmlMessage.fromXml(requestBody);
            WxMpXmlOutMessage outMessage = this.route(inMessage);
            if (outMessage == null) {
                return "";
            }
            out = outMessage.toXml();
        } else if ("aes".equalsIgnoreCase(encType)) {
            // aes加密的消息 - 微信测试号没支持 aes
            WxMpXmlMessage inMessage = WxMpXmlMessage.fromEncryptedXml(requestBody, wxMpService.getWxMpConfigStorage(),
                    timestamp, nonce, msgSignature);
            log.debug("\n消息解密后内容为：\n{} ", inMessage.toString());
            WxMpXmlOutMessage outMessage = this.route(inMessage);
            if (outMessage == null) {
                return "";
            }
            out = outMessage.toEncryptedXml(wxMpService.getWxMpConfigStorage());
        }
        return out;
    }

    private WxMpXmlOutMessage route(WxMpXmlMessage message) {
        try {
            return this.wxMpMessageRouter.route(message);
        } catch (Exception e) {
            log.error("路由消息时出现异常！", e);
        }
        return null;
    }
}
