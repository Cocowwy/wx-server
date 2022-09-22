package cn.cocowwy.server.domain.dto;

import lombok.Data;
import lombok.ToString;

/**
 * 微信推送事件
 * @author cocowwy.cn
 * @create 2022-05-05-11:45
 */
@Data
@ToString(callSuper = true)
public class WxEventPushDto extends WxPushBaseDto {
    private String event;
    private String eventKey;
    private String ticket;
}
