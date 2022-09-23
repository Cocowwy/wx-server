package cn.cocowwy.server.handler.impl;

import cn.cocowwy.server.domain.dto.WxEventPushDto;
import cn.cocowwy.server.enums.WxEventEnum;
import cn.cocowwy.server.handler.WxEventHandler;
import cn.hutool.core.util.JAXBUtil;
import cn.hutool.core.util.XmlUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 订阅事件处理
 * @author cocowwy.cn
 * @create 2022-05-05-11:45
 */
@Slf4j
@Service
public class SubscribeEventHandler implements WxEventHandler {
    @Override
    public WxEventEnum type() {
        return WxEventEnum.subscribe;
    }

    @Override
    public WxEventPushDto before(WxEventPushDto event) {
        log.info("接收事件： " + event.toString());
        return WxEventHandler.super.before(event);
    }

    /**
     * 订阅事件逻辑处理
     * @param event 事件
     */
    @Override
    public void doHandler(WxEventPushDto event) {

    }

    /**
     * 订阅后置处理
     * @param event 事件
     * @return
     */
    @Override
    public String after(WxEventPushDto event) {
        String back = "<xml>\n" +
                "  <Content>谢谢你这么好看还来关注我~</Content>\n" +
                "  <CreateTime>" + event.getCreateTime() + "</CreateTime>\n" +
                "  <ToUserName>" + event.getFromUserName() + "</ToUserName>\n" +
                "  <FromUserName>" + event.getToUserName() + "</FromUserName>\n" +
                "  <MsgType>text</MsgType>\n" +
                "</xml>";

        // 回复消息内容
        log.info(back);
        return back;
    }
}
