package cn.cocowwy.server.handler.impl;

import cn.cocowwy.server.domain.dto.WxEventPushDto;
import cn.cocowwy.server.enums.WxEventEnum;
import cn.cocowwy.server.handler.WxEventHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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

    @Override
    public void doHandler(WxEventPushDto event) {

    }
}
