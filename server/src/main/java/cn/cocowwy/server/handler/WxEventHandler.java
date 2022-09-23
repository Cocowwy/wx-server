package cn.cocowwy.server.handler;

import cn.cocowwy.server.domain.dto.WxEventPushDto;
import cn.cocowwy.server.enums.WxEventEnum;

/**
 * 微信事件处理
 * 所有 impl 必须实现 type 的返回值，来进行路由
 * @author cocowwy.cn
 * @create 2022-05-05-11:45
 */
public interface WxEventHandler {

    /**
     * 事件类型 用于路由
     * @return
     */
    WxEventEnum type();

    /**
     * 预留前置处理，便于之后进行解密等操作
     * @param event 事件
     * @return
     */
    default WxEventPushDto before(WxEventPushDto event) {
        return event;
    }

    /**
     * 预留后置操作
     * @param event 事件
     */
    default String after(WxEventPushDto event) {
        return "";
    }

    /**
     * 实际事件的逻辑处理 impl的逻辑实现
     * @param event 事件
     */
    void doHandler(WxEventPushDto event);

    default String handler(WxEventPushDto event) {
        doHandler(before(event));
        return after(event);
    }
}
