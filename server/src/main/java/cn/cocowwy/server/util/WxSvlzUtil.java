package cn.cocowwy.server.util;

import cn.cocowwy.server.domain.dto.WxEventPushDto;
import cn.cocowwy.server.domain.dto.WxPushBaseDto;

import java.util.Map;

/**
 * @author cocowwy.cn
 * @create 2022-05-05-11:45
 */
public class WxSvlzUtil {

    public static WxPushBaseDto svlz2Base(Map<String, Object> eventData) {
        WxPushBaseDto event = new WxPushBaseDto();
        event.setToUserName(String.valueOf(eventData.get("ToUserName")));
        event.setFromUserName(String.valueOf(eventData.get("FromUserName")));
        event.setCreateTime(Long.valueOf(String.valueOf(eventData.get("CreateTime"))));
        event.setMsgType(String.valueOf(eventData.get("MsgType")));
        return event;
    }

    public static WxEventPushDto svlz2Event(Map<String, Object> eventData) {
        WxEventPushDto event = new WxEventPushDto();
        event.setEvent(String.valueOf(eventData.get("ToUserName")));
        event.setFromUserName(String.valueOf(eventData.get("FromUserName")));
        event.setCreateTime(Long.valueOf(String.valueOf(eventData.get("CreateTime"))));
        event.setMsgType(String.valueOf(eventData.get("MsgType")));
        event.setEvent(String.valueOf(eventData.get("Event")));
        event.setEventKey(String.valueOf(eventData.get("EventKey")));
        event.setTicket(String.valueOf(eventData.get("Ticket")));
        return event;
    }
}
