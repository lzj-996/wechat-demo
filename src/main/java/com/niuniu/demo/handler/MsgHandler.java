package com.niuniu.demo.handler;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.niuniu.demo.service.WechatService;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static me.chanjar.weixin.common.api.WxConsts.XmlMsgType;

/**
 * @author lzj
 * @date 2022/8/16 14:18
 * @description:
 */
@Component
@Slf4j
public class MsgHandler extends AbstractHandler {

    /**
     * 当前机器人类型
     * 1.yqk
     * 2.sz
     */
    private static String CURRENT_BOT_TYPE = "1";

    private static final String YQK_BOT_TYPE = "1";

    private static final String SZ_BOT_TYPE = "2";

    private static final List<String> BOT_TYPE_LIST = new ArrayList<>();

    static {
        BOT_TYPE_LIST.add(YQK_BOT_TYPE);
        BOT_TYPE_LIST.add(SZ_BOT_TYPE);
    }

    @Autowired
    @Lazy
    private WechatService wechatService;

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService weixinService,
                                    WxSessionManager sessionManager) {

        //如果是文字
        if (wxMessage.getMsgType().equals(XmlMsgType.TEXT)) {
            if (BOT_TYPE_LIST.contains(wxMessage.getContent())) {
                CURRENT_BOT_TYPE = wxMessage.getContent();
                String msg = "切换成功，当前选手为：智障机器人" + CURRENT_BOT_TYPE + "号";
                log.info("回复微信消息：{}", msg);
                return WxMpXmlOutMessage.TEXT()
                        .content(msg)
                        .fromUser(wxMessage.getToUser())
                        .toUser(wxMessage.getFromUser())
                        .build();
            }

            String retarded = getBot(wxMessage.getContent(), CURRENT_BOT_TYPE);
            log.info("回复微信消息：{}", retarded);
            return WxMpXmlOutMessage.TEXT()
                    .content(retarded)
                    .fromUser(wxMessage.getToUser())
                    .toUser(wxMessage.getFromUser())
                    .build();
        } else {
            String s = "暂不支持其他消息类型，请开口让我去开发，我不会拒绝的！！！";
            log.info("回复微信消息：{}", s);
            return WxMpXmlOutMessage.TEXT()
                    .content(s)
                    .fromUser(wxMessage.getToUser())
                    .toUser(wxMessage.getFromUser())
                    .build();
        }
    }

    /**
     * 获取信息
     *
     * @param content
     * @param currentBotType
     * @return
     */
    private String getBot(String content, String currentBotType) {
        String reMsg;
        switch (currentBotType) {
            case YQK_BOT_TYPE:
                reMsg = qykBot(content);
                break;
            case SZ_BOT_TYPE:
                reMsg = szBot(content);
                break;
            default:
                reMsg = qykBot(content);
                break;
        }
        if (StrUtil.isEmpty(reMsg)) {
            reMsg = "我炸了我网络好像有问题，当前为智障机器人" + CURRENT_BOT_TYPE + "号,可以请按对应数字切换智障聊天机器人：" + JSON.toJSONString(BOT_TYPE_LIST);
        }
        return reMsg;
    }


    /**
     * 青云客的智障聊天机器人 http://api.qingyunke.com/
     *
     * @param msg
     * @return
     */
    private String qykBot(String msg) {
        try {
            String resultString = HttpUtil.get("http://api.qingyunke.com/api.php?key=free&appid=0&msg=" + msg, 3000);
            JSONObject resultJson = JSON.parseObject(resultString);
            Integer result = resultJson.getInteger("result");
            if (result == null || result != 0) {
                log.error("请求聊天接口失败：{}", resultString);
                return null;
            } else {
                return resultJson.getString("content");
            }
        } catch (Exception e) {
            log.error("请求聊天接口失败", e);
            return null;
        }

    }

    /**
     * 思只智障机器人 https://www.ownthink.com/
     *
     * @param msg
     * @return
     */
    public String szBot(String msg) {
        try {
            String resultString = HttpUtil.get("https://api.ownthink.com/bot?appid=xiaosi&userid=user&spoken=" + msg, 3000);
            JSONObject resultJson = JSON.parseObject(resultString);
            String message = resultJson.getString("message");
            if (!"success".equals(message)) {
                log.error("请求聊天接口失败：{}", resultString);
                return null;
            } else {
                return resultJson.getJSONObject("data").getJSONObject("info").getString("text");
            }
        } catch (Exception e) {
            log.error("请求聊天接口失败", e);
            return null;
        }
    }
}
